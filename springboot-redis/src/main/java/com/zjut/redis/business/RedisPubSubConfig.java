package com.zjut.redis.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author yuanweipeng
 * @date 2018-04-27
 **/
@Configuration
public class RedisPubSubConfig {

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory factory, MessageListener messageListener){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(messageListener, new ChannelTopic("channel-topic"));
        return container;
    }

}
