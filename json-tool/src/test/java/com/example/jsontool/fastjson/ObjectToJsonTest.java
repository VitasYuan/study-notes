package com.example.jsontool.fastjson;

import org.junit.Test;

import java.util.Date;

import static com.example.jsontool.fastjson.ObjectToJson.toJson;

/**
 * @author yuanweipeng
 * @date 2018-10-10
 **/
public class ObjectToJsonTest {

    @Test
    public void objectToJson(){
        User user = User.getInstance(12,"testName", "male", "1898911111111", "123@gmail.com", new Date());
        System.out.println(toJson(user));
    }


}
