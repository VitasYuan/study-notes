package com.example.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;


/**
 * 实现此接口来注册定时任务用的线程池
 * By default, will be searching for an associated scheduler definition: either a unique TaskScheduler bean in the context, or a TaskScheduler bean named "taskScheduler" otherwise; the same lookup will also be performed for a ScheduledExecutorService bean. If neither of the two is resolvable, a local single-threaded default
 * scheduler will be created and used within the registrar.
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

//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.setScheduler(taskExecutor());
//    }
//
//    @Bean(destroyMethod="shutdown") //保证线程池被正确关闭
//    public Executor taskExecutor() {
//        return Executors.newScheduledThreadPool(100);
//    }

//     <beans> xml-based 配置
//
//     <task:annotation-driven scheduler="taskScheduler"/>
//
//     <task:scheduler id="taskScheduler" pool-size="42"/>
//
//     <task:scheduled-tasks scheduler="taskScheduler">
//         <task:scheduled ref="myTask" method="work" fixed-rate="1000"/>
//     </task:scheduled-tasks>
//
//     <bean id="myTask" class="com.foo.MyTask"/>
//
// </beans>

}
