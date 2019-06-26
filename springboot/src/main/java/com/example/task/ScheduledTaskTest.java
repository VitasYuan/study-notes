package com.example.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Spring定时任务：
 * 定时任务使用的线程池为：SchedulingConfigurer实现类里面返回线程池实例
 * fixedDelay：上一次任务执行完计算时间间隔
 * fixedRate：上一次任务被唤醒计算时间间隔
 * @author yuanweipeng
 * @date 2018-01-21
 **/
@Component
public class ScheduledTaskTest {

    private Logger logger = LoggerFactory.getLogger("TIME_TASK_LOG");

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    @Scheduled(fixedDelay = 1000 * 5)
    public void printTime(){
        logger.info(Thread.currentThread().getName());
        logger.info("Concurrent time is:" + format.format(new Date()));
    }


    @Scheduled(cron = "0 23 11 * * * ")
    public void test1() throws Exception{
        logger.info("test1 start at :" + System.currentTimeMillis());
        logger.info(Thread.currentThread().getName());
        logger.info("Concurrent time is:" + format.format(new Date()));
        Thread.sleep(1000 * 10);
        logger.info("test1 finished at :" + System.currentTimeMillis());

    }

    @Scheduled(cron = "0 23 11 * * * ")
    public void test2() throws Exception{
        logger.info("test2 start at :" + System.currentTimeMillis());
        logger.info(Thread.currentThread().getName());
        logger.info("Concurrent time is:" + format.format(new Date()));
        Thread.sleep(1000 * 10);
        logger.info("test2 finished at :" + System.currentTimeMillis());

    }

    @Scheduled(cron = "0 23 11 * * * ")
    public void test3() throws Exception{
        logger.info("test3 start at :" + System.currentTimeMillis());
        logger.info(Thread.currentThread().getName());
        logger.info("Concurrent time is:" + format.format(new Date()));
        Thread.sleep(1000 * 10);
        logger.info("test3 finished at :" + System.currentTimeMillis());

    }
}
