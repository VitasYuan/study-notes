package com.example.web.config.redis.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yuanweipeng
 * @date 2018-02-23
 **/
//@Configuration
public class JedisClusterConfig {

    @Autowired
    private RedisClusterProperties clusterProperties;

    @Bean
    public JedisCluster clusterConnectionFactory(){
        List<String> nodeList = clusterProperties.getNodes();
        Set<HostAndPort> nodeSet = new HashSet<>();
        for (String node : nodeList) {
            String[] ipPortPair = node.split(":");
            nodeSet.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }

        return new JedisCluster(nodeSet,clusterProperties.getTimeout(), clusterProperties.getMaxAttempts());
    }

}
