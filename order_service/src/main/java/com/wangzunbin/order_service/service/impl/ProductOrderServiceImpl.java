package com.wangzunbin.order_service.service.impl;

import com.wangzunbin.order_service.domain.ProductOrder;
import com.wangzunbin.order_service.service.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

/**
 * ClassName:ProductOrderServiceImpl  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/22 16:44   <br/>
 */

@Service
public class ProductOrderServiceImpl implements IProductOrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductOrder save(Integer userId, Integer productId) {
        // 获取商品Id
        Object object = restTemplate.getForObject("http://product-service/api/v1/product/find?id=" + productId, Object.class);
        System.out.println(object);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreatime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        return productOrder;
    }
}
