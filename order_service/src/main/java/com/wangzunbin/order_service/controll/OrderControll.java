package com.wangzunbin.order_service.controll;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangzunbin.order_service.service.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(Integer userId, Integer productId){
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("data", productOrderService.save(userId, productId));
        return data;
    }

    private Object saveOrderFail(Integer userId, Integer productId){
        Map<String, Object> data = new HashMap<>();
        data.put("code", 1);
        data.put("msg", "亲, 抢购的人数太多, 亲稍后重试");
        return data;
    }
}
