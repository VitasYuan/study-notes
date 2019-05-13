package com.zjut.mybatis.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yuanweipeng
 * @date 2019-05-13
 **/
public class HelloWorldCglib implements MethodInterceptor {

    private Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("HelloWorldProxy start....");
        Object result = methodProxy.invokeSuper(o, objects);

        System.out.println("HelloWorldProxy finished....");

        return result;
    }

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public static void main(String[] args) {
        HelloWorldCglib proxy = new HelloWorldCglib();
        HelloWorldService service = (HelloWorldService) proxy.getInstance(new HelloWorldServiceImpl());
        service.sayHello("Tony");
    }
}
