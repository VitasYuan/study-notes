package com.example.web.controller;

import com.example.business.event.CustomPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yuanweipeng
 * @date 2018-02-08
 **/
@RestController
public class EventController {

    @Autowired
    private CustomPublisher customPublisher;

    @RequestMapping(value = "/event")
    public String eventPublish(){

        System.out.println("EventController thread name is :" + Thread.currentThread().getName());
        customPublisher.publisher();
        System.out.println("EventController finished.");
        return "success";

    }
}
