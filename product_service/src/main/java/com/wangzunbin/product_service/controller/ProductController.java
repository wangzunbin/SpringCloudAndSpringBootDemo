package com.wangzunbin.product_service.controller;

import com.wangzunbin.product_service.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:ProductController  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/22 11:54   <br/>
 */

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("list")
    public Object list(){
        return productService.listProduct();
    }

    @RequestMapping("find")
    public Object findByid(Integer id){
        return productService.findById(id);
    }
}
