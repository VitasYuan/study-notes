package com.example.business.asynctask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 方法的异步调用：
 * 1.方法添加Async注解定义异步方法
 * 2.配置类中添加@EnableAsync方法开启异步调用功能
 * 3.实现AsyncConfigurer接口，并实现getAsyncExecutor方法，返回异步方法执行的时候所用的线程池
 * 通过System.out.println(Thread.currentThread().getName());查看是否是异步执行
 * <p>
 * 当为不同异步方法分配不同线程池的时候：
 * 通过在Async注解中指定value的值
 * 可以通过返回Future的方式实现异步转同步
 *
 * @author yuanweipeng
 **/
@Component
public class AsyncTaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger("ASYNC_TASK_LOG");

//    @Async(value = "asyncTaskThreadPool")//可以用于type，标识此类中所有方法都为异步方法,方法中可指定线程池名称覆盖
    public void asyncTask1() {
        LOGGER.info("AsyncTask1 start.");
        LOGGER.info(Thread.currentThread().getName());
        LOGGER.info("AsyncTask1 finished.");
    }

//    @Async(value = "asyncTaskThreadPool")
    public void asyncTask2() {
        LOGGER.info("AsyncTask2 start.");
        LOGGER.info(Thread.currentThread().getName());
        LOGGER.info("AsyncTask2 finished.");
    }

//    @Async(value = "asyncTaskThreadPool")
    public Future<String> asyncTaskWithResult() {
        LOGGER.info("AsyncTaskWithResult start.");
        try {
            Thread.sleep(1000 * 10);
        } catch (Exception e) {
            return new AsyncResult<>("error" + e.getMessage());
        }
        LOGGER.info("AsyncTaskWithResult finished.");

        return new AsyncResult<>("success");
    }

    @Async
    public String test(){
        System.out.println(Thread.currentThread().getName());
        return "tewt";
    }
}
