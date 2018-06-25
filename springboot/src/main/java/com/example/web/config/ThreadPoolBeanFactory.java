package com.example.web.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * EnableAsync 开启异步任务
 * AsyncConfigurer返回异步任务用的线程池
 * By default, Spring will be searching for an associated thread pool definition:
 * either a unique TaskExecutor bean in the context, or an Executor bean named "taskExecutor"
 * otherwise. If neither of the two is resolvable, a SimpleAsyncTaskExecutor will be used to process async method invocations. Besides, annotated methods having a void return type cannot transmit any exception back to the caller. By default, such uncaught exceptions are only logged.
 *
 * @author yuanweipeng
 * @date 2018-02-06
 **/
@Configuration
@EnableAsync
public class ThreadPoolBeanFactory extends AsyncConfigurerSupport{

//    /**
//     *
//     * @return 线程池Executor
//     */
//    @Bean(name = "asyncTaskThreadPool")
//    public Executor asyncTaskThreadPool() {
//
//        ThreadPoolTaskExecutor asyncTaskThreadPool = new ThreadPoolTaskExecutor();
//        asyncTaskThreadPool.setCorePoolSize(100);
//        asyncTaskThreadPool.setMaxPoolSize(200);
//        asyncTaskThreadPool.setThreadFactory(new ThreadFactory() {
//
//            private final AtomicLong index = new AtomicLong(1);
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(r, "Async-task-pool-thread-" + index.getAndIncrement());
//            }
//        });
//        asyncTaskThreadPool.initialize();//当为bean的时候不需要调用此方法，装载容器的时候回自动调用
//        return asyncTaskThreadPool;
//    }

//    @Override
//    public Executor getAsyncExecutor() {//没有定义springBean
//        ThreadPoolTaskExecutor asyncTaskThreadPool = new ThreadPoolTaskExecutor();
//        asyncTaskThreadPool.setCorePoolSize(100);
//        asyncTaskThreadPool.setMaxPoolSize(200);
//        asyncTaskThreadPool.setQueueCapacity(11);
//        asyncTaskThreadPool.setThreadFactory(new ThreadFactory() {
//
//            private final AtomicLong index = new AtomicLong(1);
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(r, "Async-task-pool-thread-" + index.getAndIncrement());
//            }
//        });
//        asyncTaskThreadPool.initialize();
//        return asyncTaskThreadPool;
//    }
//xml-based configuration
//    <beans>
//
//     <task:annotation-driven executor="myExecutor" exception-handler="exceptionHandler"/>
//
//     <task:executor id="myExecutor" pool-size="7-42" queue-capacity="11"/>
//
//     <bean id="asyncBean" class="com.foo.MyAsyncBean"/>
//
//     <bean id="exceptionHandler" class="com.foo.MyAsyncUncaughtExceptionHandler"/>
//
// </beans>

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        //返回值为void的异步方法不会传递异常，当方法中出现异常的时候只会打印日志，重写此方法来自定义异常处理方法
        return null;
    }
}
