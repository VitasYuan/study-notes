package com.zjut.redis.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanweipeng
 * @date 2018-03-12
 **/
@Component
public class RedisPublishTask {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Scheduled(fixedDelay = 1000 * 5)
    public void printTime(){
        String channel = "channel-topic";
        Map<String, String> msg = new HashMap<>(2);
        msg.put("name", "ywp");
        msg.put("age", "30");
        redisTemplate.convertAndSend(channel, msg);
        System.out.println("asfsafasf" + System.currentTimeMillis());
    }

}
