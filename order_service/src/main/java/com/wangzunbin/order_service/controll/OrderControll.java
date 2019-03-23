package com.wangzunbin.order_service.controll;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangzunbin.order_service.service.IProductOrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:OrderControll  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/22 16:42   <br/>
 */

@RestController
@RequestMapping("api/v1/order")
public class OrderControll {

    @Autowired
    private IProductOrderService productOrderService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(Integer userId, Integer productId, HttpServletRequest request){
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("data", productOrderService.save(userId, productId));
        return data;
    }

    private Object saveOrderFail(Integer userId, Integer productId, HttpServletRequest request){

        //监控报警
        String saveOrderKye = "save-order";
        String sendValue = (String) redisTemplate.opsForValue().get(saveOrderKye);
        final String ip = request.getRemoteAddr();
        new Thread( ()->{
            if (StringUtils.isBlank(sendValue)) {
                System.out.println("紧急短信，用户下单失败，请离开查找原因,ip地址是="+ip);
                //发送一个http请求，调用短信服务 TODO
                redisTemplate.opsForValue().set(saveOrderKye, "save-order-fail", 20, TimeUnit.SECONDS);
            }else{
                System.out.println("已经发送过短信，20秒内不重复发送");
            }
        }).start();

        Map<String, Object> data = new HashMap<>();
        data.put("code", 1);
        data.put("msg", "亲, 抢购的人数太多, 亲稍后重试");
        return data;
    }
}
