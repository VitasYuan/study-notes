package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yuanweipeng
 * @date 2018-03-09
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate<String, Object> template;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void redisTest(){
//        template.opsForValue().set("testKey1", "1231test");
//        System.out.println(template.opsForValue().get("yuanweipeng"));
//        Dictionary dictionary = new Dictionary();
//        template.opsForValue().set("dictionaryTest2", dictionary);
        template.opsForValue().set("yuanweipeng", "yuanweipeng111TEST");
        System.out.println(template.opsForValue().get("yuanweipeng"));
        redisTemplate.convertAndSend("hello", "world");

    }

}
