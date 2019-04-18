package com.zjut.controller;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuanweipeng
 * @date 2019-04-17
 **/
@Controller
@RequestMapping(value = "/aware")
public class AwareTestController implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String getHourAverage(){
        String[] envs = environment.getActiveProfiles();
        for (String env : envs) {
            System.out.println(env);
        }

        return "success";
    }


}
