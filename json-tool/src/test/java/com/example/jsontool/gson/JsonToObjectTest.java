package com.example.jsontool.gson;

import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.jsontool.gson.JsonToObject.fromObject;

/**
 * @author yuanweipeng
 * @date 2018-10-10
 **/
public class JsonToObjectTest {

    @Test
    public void stringToMap(){
        String[] result = fromObject("[\"tesq1\",\"test2\",\"test3\"]", String[].class);

        Map<String, Object> mapResult = fromObject("{\"testMap1\":\"testMapValue1\",\"testMapKey2\":\"testMapvalue2\",\"testdDate\":\"2018-09-30 19:32:37\",\"testMapKey3\":\"testMapValue3\"}", HashMap.class);
        return;
    }

    @Test
    public void stringToCollect(){
        Type type = new TypeToken<List<User>>(){}.getType();
        List<User> userList = fromObject("[{\"id\":1,\"name\":\"test1\",\"gender\":\"male\",\"phoneNumber\":\"1898921111\",\"email\":\"test@sina.cn\"},{\"id\":2,\"name\":\"test2\",\"gender\":\"male\",\"phoneNumber\":\"1898921112\",\"email\":\"test@sina.cn\"},{\"id\":3,\"name\":\"test3\",\"gender\":\"male\",\"phoneNumber\":\"1898921113\",\"email\":\"test@sina.cn\"},{\"id\":4,\"name\":\"test4\",\"gender\":\"male\",\"phoneNumber\":\"1898921114\",\"email\":\"test@sina.cn\"}]", type);
        for (User user : userList) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void stringToObject(){
        String json = "{\"id\":1,\"name\":\"test1\",\"gender\":\"male\",\"phoneNumber\":\"1898921111\",\"email\":\"test@sina.cn\",\"createdTime\":\"2018-10-10 13:40:26\"}";
        User user = fromObject(json, User.class);
        System.out.println(user.getName());
    }
}
