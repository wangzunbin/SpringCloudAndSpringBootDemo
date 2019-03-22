package com.wangzunbin.product_service.service;

import com.wangzunbin.product_service.domain.Product;

import java.util.List;

/**
 * ClassName:IProductService  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/22 11:58   <br/>
 */
public interface IProductService {

    List<Product> listProduct();

    Product findById(Integer id);
}
