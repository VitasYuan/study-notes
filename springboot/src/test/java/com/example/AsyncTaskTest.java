package com.example;

import com.example.business.asynctask.AsyncTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yuanweipeng
 * @date 2018-02-06
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class AsyncTaskTest {


    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Test
    public void asyncTest(){
//        asyncTaskService.asyncTask1();
//        asyncTaskService.asyncTask2();
//        asyncTaskService.test();
//        System.out.println("asyncTest finished.");

        Object object = applicationContext.getBean("test1,test2");
        System.out.println(object.getClass().getTypeName());

        object = applicationContext.getBean("test2");
        System.out.println(object.getClass().getTypeName());




    }

}
