package com.example.jsontool.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author yuanweipeng
 * @date 2018-09-30
 **/
public final class ObjectToJson {

    /**
     * thread-safe setDateFormat 为设置序列化Date类型对象的格式
     */
    private static final Gson gson = new GsonBuilder()
            .serializeNulls()
            .excludeFieldsWithoutExposeAnnotation()
            .setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /**
     * 将对象转换为json字符串
     *
     * @param target 需要转换的对象
     * @return 转换后的json字符串
     */
    public static String toJson(Object target) {
        return gson.toJson(target);
    }

}
