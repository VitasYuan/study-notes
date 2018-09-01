package com.example.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author weipeng_yuan
 * @date 2018-08-31
 */
public class NetworkConnectorDP implements InvocationHandler {

    private Object realObject;

    public NetworkConnectorDP(Object realObject){
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
        return method.invoke(this.realObject, args);
    }
}
