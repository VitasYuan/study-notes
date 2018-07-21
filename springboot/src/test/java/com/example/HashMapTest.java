package com.example;

import java.util.*;

public class HashMapTest {



    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "test");
        map.put("age", "25");
        map.put("address", "HZ");

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(map.get(key));
        }

        Set<Map.Entry<String, Object>> set = map.entrySet();
        for (Map.Entry<String, Object> entry : set) {
            System.out.println("key is : " + entry.getKey() + ".  value is " + entry.getValue());
        }
    }

}
