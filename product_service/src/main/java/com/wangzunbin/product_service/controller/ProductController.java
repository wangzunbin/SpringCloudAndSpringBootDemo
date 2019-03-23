package com.wangzunbin.product_service.controller;

import com.wangzunbin.product_service.domain.Product;
import com.wangzunbin.product_service.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.port}")
    private String port;

    @Autowired
    private IProductService productService;

    @RequestMapping("list")
    public Object list(){
        return productService.listProduct();
    }

    @RequestMapping("find")
    public Object findByid(Integer id){

      /*  try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Product product = productService.findById(id);
        Product product1 = new Product();
        BeanUtils.copyProperties(product, product1);
        product1.setName(product1.getName() + " data from port=" + port);
        return product1;
    }
}
