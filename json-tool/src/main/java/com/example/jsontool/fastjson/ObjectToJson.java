package com.example.jsontool.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;

/**
 * @author yuanweipeng
 * @date 2018-10-10
 **/
public final class ObjectToJson {

    private static SerializeConfig serializeConfig = new SerializeConfig(true);

    public static String toJson(Object object){
        return JSON.toJSONString(object, serializeConfig);
    }
}
