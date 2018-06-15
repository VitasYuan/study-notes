package com.example.business.scope;

import org.springframework.stereotype.Service;

/**
 * spring中的bean默认加载为单例，当定义变量时候需要注意多线程问题
 * 单利模式下所有自动注入的bean都为同一个对象
 *
 * @author yuanweipeng
 * @date 2018-01-22
 **/
@Service
public class SingletonBean {
}
