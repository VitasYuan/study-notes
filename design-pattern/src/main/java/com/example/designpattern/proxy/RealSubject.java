package com.example.designpattern.proxy;

/**
 * @author weipeng_yuan
 * @date 2018-08-31
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("Send request:" + "....");
    }
}
