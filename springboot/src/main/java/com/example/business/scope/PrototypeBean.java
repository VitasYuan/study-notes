package com.example.business.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 使用scope注解并制定prototype为多例
 * 此模式下每一个主动注入的bean为一个单独的对象，和请求无关
 * @author yuanweipeng
 * @date 2018-01-22
 **/
@Service
@Scope(value = "prototype")
public class PrototypeBean {
}
