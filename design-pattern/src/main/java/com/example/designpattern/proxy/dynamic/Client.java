package com.example.designpattern.proxy.dynamic;

import com.sun.deploy.net.proxy.DynamicProxyManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author weipeng_yuan
 * @date 2018-08-31
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Connector connector = new NetworkConnector();

        InvocationHandler handler = new NetworkConnectorDP(connector);
        ClassLoader classLoader = connector.getClass().getClassLoader();

        Connector proxy = (Connector) Proxy.newProxyInstance(classLoader, new Class[]{Connector.class}, handler);
        System.out.println("Start connect to network.");
        proxy.connect();
        System.out.println("Connect to network finished.");


    }
}
