package com.zjut.controller;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * @author yuanweipeng
 * @date 2019-04-18
 **/
@Component
public class ServletRequestHandledEventListener implements ApplicationListener<ServletRequestHandledEvent> {
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        System.out.println("method:" + event.getMethod() + ".desc:" + event.getDescription() + ".requestUrl"
                + event.getRequestUrl() + ".statusCode:" + event.getStatusCode() + ".clientAddress:"
                + event.getClientAddress());

    }
}
