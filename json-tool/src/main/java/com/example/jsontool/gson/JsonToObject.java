package com.example.jsontool.gson;

import com.example.jsontool.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Map;

/**
 * @author yuanweipeng
 * @date 2018-09-30
 **/
public final class JsonToObject {

    /**
     * thread-safe
     */
    private static final Gson gson = new GsonBuilder().create();

    public static <T> T fromObject(String json, Class<T> clz){
         return gson.fromJson(json, clz);
    }

    public static void main(String[] args) throws Exception {
        String[] result = fromObject("[\"tesq1\",\"test2\",\"test3\"]", String[].class);

        Map<String, Object> mapResult = fromObject("{\"testMap1\":\"testMapValue1\",\"testMapKey2\":\"testMapvalue2\",\"testdDate\":\"2018-09-30 19:32:37\",\"testMapKey3\":\"testMapValue3\"}", Map.class);
        List<User> userList = fromObject("[{\"id\":1,\"name\":\"test1\",\"gender\":\"male\",\"phoneNumber\":\"1898921111\",\"email\":\"test@sina.cn\"},{\"id\":2,\"name\":\"test2\",\"gender\":\"male\",\"phoneNumber\":\"1898921112\",\"email\":\"test@sina.cn\"},{\"id\":3,\"name\":\"test3\",\"gender\":\"male\",\"phoneNumber\":\"1898921113\",\"email\":\"test@sina.cn\"},{\"id\":4,\"name\":\"test4\",\"gender\":\"male\",\"phoneNumber\":\"1898921114\",\"email\":\"test@sina.cn\"}]", List.class);
        return;

    }
}
