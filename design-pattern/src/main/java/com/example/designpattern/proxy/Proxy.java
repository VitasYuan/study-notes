package com.example.designpattern.proxy;

/**
 * @author weipeng_yuan
 * @date 2018-08-31
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public void request() {
        subject.request();
    }

    private void before(){
        // do before
    }

    private void after(){
        //do after
    }
}
