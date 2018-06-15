package com.example.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * EnableAsync 开启异步任务
 * AsyncConfigurer返回异步任务用的线程池
 *
 * @author yuanweipeng
 * @date 2018-02-06
 **/
@Configuration
@EnableAsync
public class ThreadPoolBeanFactory{

    /**
     *
     * @return 线程池Executor
     */
    @Bean(name = "asyncTaskThreadPool")
    public Executor asyncTaskThreadPool() {

        ThreadPoolTaskExecutor asyncTaskThreadPool = new ThreadPoolTaskExecutor();
        asyncTaskThreadPool.setCorePoolSize(100);
        asyncTaskThreadPool.setMaxPoolSize(200);
        asyncTaskThreadPool.setThreadFactory(new ThreadFactory() {

            private final AtomicLong index = new AtomicLong(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Async-task-pool-thread-" + index.getAndIncrement());
            }
        });
        asyncTaskThreadPool.initialize();
        return asyncTaskThreadPool;
    }

}
