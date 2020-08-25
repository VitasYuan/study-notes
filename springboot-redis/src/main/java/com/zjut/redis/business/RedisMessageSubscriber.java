package com.zjut.redis.business;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yuanweipeng
 * @date 2018-03-12
 **/
@Component
public class RedisMessageSubscriber implements MessageListener{

    @Override
    public void onMessage(Message message, byte[] pattern) {
        byte[] body = message.getBody();
        ObjectRedisSerializer serializer = new ObjectRedisSerializer();
        try {
            Thread.sleep(1000 * 20);

        } catch (Exception e) {

        }
        Map<String, String> value = (Map<String, String>) serializer.deserialize(body);
        System.out.println(value.toString());
    }
}
