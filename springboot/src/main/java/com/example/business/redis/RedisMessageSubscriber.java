package com.example.business.redis;

import com.example.business.cache.redis.ObjectRedisSerializer;
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
        Map<String, String> value = (Map<String, String>) serializer.deserialize(body);
        System.out.println(value.toString());
    }
}
