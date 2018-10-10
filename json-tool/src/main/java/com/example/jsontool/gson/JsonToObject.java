package com.example.jsontool.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * @author yuanweipeng
 * @date 2018-09-30
 **/
public final class JsonToObject {

    /**
     * thread-safe
     */
    private static final Gson gson = new GsonBuilder().serializeNulls().create();

    /**
     * @param json json 字符串
     * @param clz 转换的目标类
     * @param <T>
     * @return 转换后的对象
     */
    public static <T> T fromObject(String json, Class<T> clz){
         return gson.fromJson(json, clz);
    }


    public static <T> T fromObject(String json, Type type){
        return gson.fromJson(json, type);
    }

}
