package com.wangzunbin.order_service.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:ProductOrder  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/22 16:37   <br/>
 */
@Data
public class ProductOrder implements Serializable {

    private Integer id;
    private String productName;
    private String tradeNo;
    private Integer price;
    private Date creatime;
    private Integer userId;
    private String username;
}
