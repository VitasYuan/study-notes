package com.example.jsontool.gson;

import org.junit.Test;

import java.util.*;

import static com.example.jsontool.gson.ObjectToJson.toJson;

/**
 * @author yuanweipeng
 * @date 2018-10-10
 **/
public class ObjectToJsonTest {

    @Test
    public void arrayToJson() {
        String[] target = {"tesq1", "test2", "test3"};
        System.out.println(toJson(target));
    }

    @Test
    public void listToJson() {
        List<String> targetList = new ArrayList<>();
        targetList.add("testList1");
        targetList.add("testList2");
        targetList.add("testList3");
        System.out.println(toJson(targetList));

        List<User> userList = new ArrayList<>();
        Date now = new Date();
        userList.add(User.getInstance(1, "test1", "male", "1898921111", "test@sina.cn", now));
        userList.add(User.getInstance(2, "test2", "male", "1898921112", "test@sina.cn", now));
        userList.add(User.getInstance(3, "test3", "male", "1898921113", "test@sina.cn", now));
        userList.add(User.getInstance(4, "test4", "male", "1898921114", "test@sina.cn", now));
        System.out.println(toJson(userList));
    }

    @Test
    public void mapToJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("testMap1", "testMapValue1");
        map.put("testMapKey2", "testMapvalue2");
        map.put("testMapKey3", "testMapValue3");
        map.put("testdDate", new Date());
        System.out.println(toJson(map));
    }

    @Test
    public void objectToJson(){
        User user = User.getInstance(1, "test1", "male", "1898921111", "test@sina.cn", null);
        System.out.println(toJson(user));
    }
}
