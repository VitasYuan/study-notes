package com.example.web.config;

import com.example.web.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author yuanweipeng
 * @date 2018-01-19
 **/
@Configuration
//@ImportResource 使用importresource来引入xml配置文件
public class WebConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor).addPathPatterns("/*");
    }
}
