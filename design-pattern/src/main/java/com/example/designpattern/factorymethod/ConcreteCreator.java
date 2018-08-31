package com.example.designpattern.factorymethod;

/**
 * @author weipeng_yuan
 * @date 2018-08-25
 */
public class ConcreteCreator {

    public static <T extends Product> T create(Class<T> c) {

        Product product = null;
        try {

            product = (Product) Class.forName(c.getName()).newInstance();

        } catch (Exception e) {

        }
        return (T)product;
    }
}
