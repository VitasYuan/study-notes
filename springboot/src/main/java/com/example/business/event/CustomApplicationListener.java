package com.example.business.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author yuanweipeng
 * @date 2018-02-08
 **/
@Component
public class CustomApplicationListener implements ApplicationListener<CustomApplicationEvent> {

    @Override
    @Async(value = "asyncTaskThreadPool")
    public void onApplicationEvent(CustomApplicationEvent event) {
        System.out.println("CustomApplicationListener thread name is :" + Thread.currentThread().getName());
        String message = event.getMessage();
        try {
            Thread.sleep(1000 * 3);

        } catch (InterruptedException e) {
            //never happened
        }
        System.out.println("CustomApplicationListener get message : " + message);

    }
}
