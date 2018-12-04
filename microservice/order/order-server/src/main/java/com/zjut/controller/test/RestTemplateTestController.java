package com.zjut.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@RestController
@RequestMapping(value = "test/")
public class RestTemplateTestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/msg")
    public String restTemplate() {
        //url直接写死，多节点不能负载均衡
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8084/test/message", String.class);
        return "restTemplage:" + result;
    }

    /**
     * 根据应用名获取服务
     */
    @RequestMapping(value = "/msg-1")
    public String restTemplate1() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/test/message";
        String result = restTemplate.getForObject(url, String.class);
        return "restTemplage:" + result;
    }

    @RequestMapping(value = "/msg-2")
    public String restTemplate2() {
        String result = restTemplate.getForObject("http://PRODUCT/test/message", String.class);
        return "restTemplate:" + result;
    }


}
