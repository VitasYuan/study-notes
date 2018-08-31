package com.example.designpattern.singleton;

/**
 * @author weipeng_yuan
 * @date 2018-08-25
 */
public class SingletonPattern {

    private static final SingletonPattern singletonPattern = new SingletonPattern();

    private SingletonPattern(){

    }

    public static SingletonPattern getInstance(){
        return singletonPattern;
    }
}
