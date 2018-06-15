package com.example.web.controller;

import com.example.web.config.redis.cluster.JedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yuanweipeng
 * @date 2018-02-23
 **/
@RestController
public class RedisClusterTestController {

//    @Autowired
//    private JedisTemplate jedisTemplate;
//
//    @RequestMapping(value = "/redis/cluster")
//    public String clusterTest(){
//        jedisTemplate.set("testkey", "testValue");
//        return jedisTemplate.get("testkey");
//
//    }

}
