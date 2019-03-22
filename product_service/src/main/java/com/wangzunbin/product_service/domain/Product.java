package com.wangzunbin.product_service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName:Product  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/22 11:54   <br/>
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private Integer id;
    private String name;
    private Integer price;
    private Integer score;
}
