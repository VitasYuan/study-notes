package com.example.web.config.redis.cluster;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-02-23
 **/
//@Component
//@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisClusterProperties {

    /**
     * redis集群节点
     */
    private List<String> nodes;

    /**
     * 连接超时时间
     */
    private int timeout;

    /**
     * 最大重连次数
     */
    private int maxAttempts;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    @Override
    public String toString() {
        return "ClusterConfigurationProperties{" +
                "nodes=" + nodes +
                ", timeout=" + timeout +
                ", maxAttempts=" + maxAttempts +
                '}';
    }
}
