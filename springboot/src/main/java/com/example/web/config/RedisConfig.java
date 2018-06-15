package com.example.web.config;

import com.example.business.cache.redis.ObjectRedisSerializer;
import com.example.business.redis.RedisMessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisShardInfo;

/**
 * Configuration注解表示为配置类
 * @author yuanweipeng
 * @date 2018-01-19
 **/
@Configuration
public class RedisConfig {

    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    /**
     * @return redisTemplate 相当于xml中的bean
     */
    @Bean
    RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new ObjectRedisSerializer());
        return redisTemplate;
    }

//    @Bean
//    MessageListenerAdapter listenerAdapter (RedisMessageSubscriber subscriber) {
//        return new MessageListenerAdapter(subscriber, "messageSubscriber");
//    }

//    @Bean
//    RedisMessageListenerContainer container(MessageListenerAdapter listenerAdapter){
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(jedisConnectionFactory);
//        container.addMessageListener(listenerAdapter, new PatternTopic("sprinboot-redis-messaage"));
//        return container;
//    }
}
