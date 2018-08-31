package com.example.designpattern.factorymethod;

/**
 * @author weipeng_yuan
 * @date 2018-08-25
 */
public abstract class Creator {

    /**
     * @param c 需要具体创建的具体产品
     * @param <T> Product的实现类
     * @return 实例对象
     */
    public abstract <T extends Product> T create(Class<T> c);
}
