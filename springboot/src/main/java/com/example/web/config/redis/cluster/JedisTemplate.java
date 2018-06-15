package com.example.web.config.redis.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

/**
 * @author yuanweipeng
 * @date 2018-02-23
 **/
//@Component
public class JedisTemplate {

    @Autowired
    private JedisCluster jedisCluster;

    public void set(String key, String value) {
        jedisCluster.set(key, value);
    }

    public String get(String key) {
        return jedisCluster.get(key);
    }
}
