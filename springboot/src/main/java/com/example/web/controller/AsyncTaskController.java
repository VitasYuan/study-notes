package com.example.web.controller;

import com.example.business.asynctask.AsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author yuanweipeng
 * @date 2018-02-06
 **/
@RestController
public class AsyncTaskController {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @RequestMapping(value = "/async")
    public String asyncTask() throws Exception{
        asyncTaskService.asyncTask1();
        asyncTaskService.asyncTask2();
        Future<String> future = asyncTaskService.asyncTaskWithResult();

        while (!future.isDone()) {
            System.out.println("Wait asyncTaskWithResult.");
            Thread.sleep(1000);
        }
        System.out.println("asyncTask finished.");
        return "success";
    }
}
