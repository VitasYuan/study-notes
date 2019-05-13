package com.zjut.mybatis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yuanweipeng
 * @date 2019-05-13
 **/
public class HelloWorldProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{

        System.out.println("HelloWorldProxy start....");
        Object result = method.invoke(target, args);

        System.out.println("HelloWorldProxy finished....");

        return result;
    }

    public static void main(String[] args) {
        HelloWorldProxy proxy = new HelloWorldProxy();
        HelloWorldService service = (HelloWorldService) proxy.bind(new HelloWorldServiceImpl());
        service.sayHello("Tony");
    }
}
