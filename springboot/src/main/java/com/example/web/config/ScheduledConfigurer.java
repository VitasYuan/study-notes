package com.example.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;


/**
 * 实现此接口来注册定时任务用的线程池
 *
 * @author yuanweipeng
 **/
@Configuration
@EnableScheduling
public class ScheduledConfigurer implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler poolTaskScheduler = new ThreadPoolTaskScheduler();
        poolTaskScheduler.setPoolSize(50);
        poolTaskScheduler.setThreadNamePrefix("Scheduled-task-pool-thread-");
        poolTaskScheduler.initialize();
        taskRegistrar.setTaskScheduler(poolTaskScheduler);
    }
}
