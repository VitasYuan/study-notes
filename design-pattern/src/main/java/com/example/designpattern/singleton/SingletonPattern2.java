package com.example.designpattern.singleton;

/**
 * @author weipeng_yuan
 * @date 2018-08-25
 */
public class SingletonPattern2 {

    private static SingletonPattern2 singletonPattern = null;

    private SingletonPattern2() {

    }

    public static SingletonPattern2 getInstance() {
        if (singletonPattern == null) {
            synchronized (SingletonPattern.class) {
                if (singletonPattern == null) {
                    singletonPattern = new SingletonPattern2();
                }
            }
        }

        return singletonPattern;
    }
}
