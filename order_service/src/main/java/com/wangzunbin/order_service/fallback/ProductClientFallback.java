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

    /**
     * 在这里抛出异常, 一般用于数据回滚, 让最外面的熔断器接收
     * @param id 商品id
     * @return 返回数据
     */
    @Override
    public String findById(Integer id) {
        System.out.println("调用到这里的错误");
        return null;
    }
}
