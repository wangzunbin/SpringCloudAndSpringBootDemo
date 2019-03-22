package com.wangzunbin.order_service.controll;

import com.wangzunbin.order_service.domain.ProductOrder;
import com.wangzunbin.order_service.service.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Object save(Integer userId, Integer productId){
        ProductOrder save = productOrderService.save(userId, productId);
        return save;
    }
}
