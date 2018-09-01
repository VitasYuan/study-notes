package com.example.designpattern.proxy.dynamic;

/**
 * @author weipeng_yuan
 * @date 2018-08-31
 */
public class NetworkConnector implements Connector {

    @Override
    public void connect() {
        System.out.println("Connect to network.");
    }
}
