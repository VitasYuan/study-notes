package com.example;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuanweipeng
 * @date 2018-02-23
 **/
public class JedisClusterTest {

    @Test
    public void test(){
        Set<HostAndPort> nodeSet = new HashSet<>();
        nodeSet.add(new HostAndPort("127.0.0.1",7000));
        nodeSet.add(new HostAndPort("127.0.0.1",7001));
        nodeSet.add(new HostAndPort("127.0.0.1",7002));
        nodeSet.add(new HostAndPort("127.0.0.1",7003));
        nodeSet.add(new HostAndPort("127.0.0.1",7004));
        nodeSet.add(new HostAndPort("127.0.0.1",7005));

        JedisCluster cluster = new JedisCluster(nodeSet);
        for (int i=0; i<10; i++) {
            cluster.set("testkey" + i, "testvalue" + i);

        }

    }

    @Test
    public void testSingle(){
        Jedis jedis = new Jedis("123.56.21.27", 6379);
        jedis.set("teee","123123");
//        Jedis jedis1 = new Jedis("123.56.21.27", 6379);
//        System.out.println(jedis1.get("teee"));
        System.out.println(jedis.get("teee"));

    }
}
