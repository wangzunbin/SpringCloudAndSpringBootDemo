package com.wangzunbin.order_service.fallback;

import com.wangzunbin.order_service.service.IProductClient;
import org.springframework.stereotype.Component;

/**
 * ClassName:ProductClientFallback  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/23 22:00   <br/>
 */

@Component
public class ProductClientFallback implements IProductClient {

    @Override
    public String findById(Integer id) {
        System.out.println("调用到这里的错误");
        return null;
    }
}
