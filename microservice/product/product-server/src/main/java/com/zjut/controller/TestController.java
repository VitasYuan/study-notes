package com.zjut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@RestController
@RequestMapping(value = "test/")
public class TestController {

    @GetMapping(value = "/message")
    public String message(){
        return "Response:message";
    }
}
