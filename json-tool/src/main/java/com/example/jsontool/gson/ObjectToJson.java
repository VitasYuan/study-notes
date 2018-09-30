package com.example.jsontool.gson;

import com.example.jsontool.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author yuanweipeng
 * @date 2018-09-30
 **/
public final class ObjectToJson {

    /**
     * thread-safe setDateFormat 为设置序列化Date类型对象的格式
     */
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static String toJson(Object target) {
        return gson.toJson(target);
    }

    public static void main(String[] args) throws Exception {
        String[] target = {"tesq1", "test2", "test3"};
        System.out.println(toJson(target));

        List<String> targetList = new ArrayList<>();
        targetList.add("testList1");
        targetList.add("testList2");
        targetList.add("testList3");
        System.out.println(toJson(targetList));

        Map<String, Object> map = new HashMap<>();
        map.put("testMap1", "testMapValue1");
        map.put("testMapKey2", "testMapvalue2");
        map.put("testMapKey3", "testMapValue3");
        map.put("testdDate", new Date());
        System.out.println(toJson(map));

        List<User> userList = new ArrayList<>();
        Date now = new Date();
        userList.add(User.getInstance(1, "test1", "male", "1898921111", "test@sina.cn", now));
        userList.add(User.getInstance(2, "test2", "male", "1898921112", "test@sina.cn", now));
        userList.add(User.getInstance(3, "test3", "male", "1898921113", "test@sina.cn", now));
        userList.add(User.getInstance(4, "test4", "male", "1898921114", "test@sina.cn", now));
        System.out.println(toJson(userList));
    }

}
