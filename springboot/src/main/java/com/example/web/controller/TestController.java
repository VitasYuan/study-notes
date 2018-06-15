package com.example.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanweipeng
 * @date 2018-01-18
 **/
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger("EXCEPTION_LOG");

    @GetMapping(value = "/exception")
    public String exceptionTest(@RequestParam(value = "local") String local) throws Exception{
        logger.error("exception log123.");
        throw new Exception("exception test");
    }
}
