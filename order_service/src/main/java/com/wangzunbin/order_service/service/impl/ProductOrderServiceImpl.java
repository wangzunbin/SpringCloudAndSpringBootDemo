package com.wangzunbin.order_service.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.wangzunbin.order_service.domain.ProductOrder;
import com.wangzunbin.order_service.service.IProductClient;
import com.wangzunbin.order_service.service.IProductOrderService;
import com.wangzunbin.order_service.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /************  ribbon使用 start  ************/
  /*  @Autowired
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
    }*/
    /************  ribbon使用  end  ************/

    /************  Feign使用 start  ************/
    @Autowired
    private IProductClient productClient;

    @Override
    public ProductOrder save(Integer userId, Integer productId) {
        // 获取商品Id
        String res = productClient.findById(productId);
        JsonNode jsonNode = JsonUtils.str2JsonNode(res);
//        System.out.println(object);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreatime(new Date());
        productOrder.setUserId(userId);
        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        productOrder.setTradeNo(UUID.randomUUID().toString());
        return productOrder;
    }
    /************  Feign使用  end  ************/
}
