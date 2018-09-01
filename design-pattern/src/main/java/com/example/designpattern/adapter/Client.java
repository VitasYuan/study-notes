package com.example.designpattern.adapter;

/**
 * @author weipeng_yuan
 * @date 2018-09-01
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Target target = new Adapter();
        target.request();
    }
}
