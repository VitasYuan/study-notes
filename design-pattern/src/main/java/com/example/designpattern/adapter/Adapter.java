package com.example.designpattern.adapter;

/**
 * @author weipeng_yuan
 * @date 2018-09-01
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        doSomething();
    }
}
