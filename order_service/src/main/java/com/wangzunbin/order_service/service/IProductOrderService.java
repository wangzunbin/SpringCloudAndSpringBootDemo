package com.wangzunbin.order_service.service;

import com.wangzunbin.order_service.domain.ProductOrder;

/**
 * ClassName:IProductOrderService  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/22 16:44   <br/>
 */

public interface IProductOrderService {


    public ProductOrder save(Integer userId, Integer productId);
}
