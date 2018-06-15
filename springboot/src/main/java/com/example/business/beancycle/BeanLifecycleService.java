package com.example.business.beancycle;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 通过PostConstruct和PreDestroy注解定义初始化操作和bean被销毁之前的资源释放
 *
 * @author yuanweipeng
 * @date 2018-01-22
 **/
@Service
public class BeanLifecycleService {

    public BeanLifecycleService() {
        System.out.println("BeanLifecycleService construct method run.");
    }

    /**
     * 构造函数执行完执行
     */
    @PostConstruct
    public void init() {
        System.out.println("BeanLifecycleService init method run.");
    }

    /**
     * bean销毁之前执行
     */
    @PreDestroy
    public void destroy() {
        System.out.println("BeanLifecycleService destroy method run.");
    }
}
