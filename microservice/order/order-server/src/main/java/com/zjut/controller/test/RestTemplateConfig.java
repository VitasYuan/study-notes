package com.zjut.controller.test;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@Component
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate get(){
        return new RestTemplate();
    }

}
