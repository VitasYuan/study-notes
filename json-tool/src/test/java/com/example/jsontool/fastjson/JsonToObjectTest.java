package com.example.jsontool.fastjson;

import org.junit.Test;

import static com.example.jsontool.fastjson.JsonToObject.toObject;

/**
 * @author yuanweipeng
 * @date 2018-10-10
 **/
public class JsonToObjectTest {

    @Test
    public void parseObject(){
        User user = toObject("{\"createdTime\":1539152877034,\"email\":\"123@gmail.com\",\"gender\":\"male\",\"id\":12,\"name\":\"testName\",\"phoneNumber\":\"1898911111111\"}", User.class);
        System.out.println(user.getName());
    }

}
