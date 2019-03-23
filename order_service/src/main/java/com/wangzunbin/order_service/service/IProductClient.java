package com.wangzunbin.order_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:IProductClient  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/23 19:29   <br/>
 */

@FeignClient("product-service")
public interface IProductClient {

    @GetMapping("/api/v1/product/find")
    String findById(@RequestParam("id") Integer id);
}
