package com.zjut.mybatis.proxy;

/**
 * @author yuanweipeng
 * @date 2019-05-13
 **/
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
