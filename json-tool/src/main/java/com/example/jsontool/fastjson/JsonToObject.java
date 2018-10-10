package com.example.jsontool.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * @author yuanweipeng
 * @date 2018-10-10
 **/
public final class JsonToObject {

    public static <T> T toObject(String json, Class<T> clz){
        return JSON.parseObject(json, clz);
    }
}
