package com.wangzunbin.order_service.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ClassName:JsonUtils  <br/>
 * Funtion: ${TODD} <br/>
 *
 * @author WangZunBin <br/>
 * @version 0.4 2019/3/23 19:35   <br/>
 */


public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode str2JsonNode(String str){
        try {
            return objectMapper.readTree(str);
        }catch (Exception e){
            return null;
        }
    }
}
