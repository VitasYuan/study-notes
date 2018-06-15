package com.example.business.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * spring中事件订阅功能默认是同步执行，发布事件之后会等待listenner执行完毕之后才返回继续执行，打印每个类中执行的
 * 线程名称相同。可以通过在listenner中添加async注解实现异步执行
 *
 * @author yuanweipeng
 * @date 2018-02-08
 **/
@Component
public class CustomPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publisher(){
        System.out.println("CustomPublisher thread name is :" + Thread.currentThread().getName());

        applicationContext.publishEvent(new CustomApplicationEvent(this, "Customer event."));
    }


}
