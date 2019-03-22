package com.wangzunbin.product_service.service.impl;

import com.wangzunbin.product_service.domain.Product;
import com.wangzunbin.product_service.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * ClassName:ProductserviceImpl  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/22 13:25   <br/>
 */

@Service
public class ProductserviceImpl implements IProductService {

    private static final Map<Integer, Product> daoMap = new HashMap<>();

    static {
        Product p1  = new Product(1, "iphonex", 9999, 90);
        Product p2  = new Product(2, "笔", 2, 99);
        Product p3  = new Product(3, "冰箱", 3000, 80);
        Product p4  = new Product(4, "电视", 2000, 60);
        Product p5  = new Product(5, "洗衣机", 5000, 70);
        Product p6  = new Product(6, "吹风筒", 100, 80);
        Product p7  = new Product(7, "iphone xs", 8000, 95);
        Product p8  = new Product(8, "iphone xs max", 12999, 99);
        daoMap.put(p1.getId(), p1);
        daoMap.put(p2.getId(), p2);
        daoMap.put(p3.getId(), p3);
        daoMap.put(p4.getId(), p4);
        daoMap.put(p5.getId(), p5);
        daoMap.put(p6.getId(), p6);
        daoMap.put(p7.getId(), p7);
        daoMap.put(p8.getId(), p8);
    }


    @Override
    public List<Product> listProduct() {
        Collection<Product> values = daoMap.values();
        List<Product> products = new ArrayList<>(values);
        return products;
    }

    @Override
    public Product findById(Integer id) {
        return daoMap.get(id);
    }
}
