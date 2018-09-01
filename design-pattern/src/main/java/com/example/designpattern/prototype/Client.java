package com.example.designpattern.prototype;

/**
 * @author weipeng_yuan
 * @date 2018-09-01
 */
public class Client {

    public static void main(String[] args) throws Exception {
        DeepClone deepClone = new DeepClone();
        deepClone.addPair("key1", "value1");

        DeepClone clone = (DeepClone) deepClone.clone();
        clone.addPair("key2", "value2");
        System.out.println(deepClone.getMap());

    }


}
