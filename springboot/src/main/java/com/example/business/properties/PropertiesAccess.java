package com.example.business.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yuanweipeng
 * @date 2018-02-06
 **/
@Component
public class PropertiesAccess {

    /**
     * 可以通过Value注解直接读取.properties文件的配置信息，其中语法为el表达式：
     * 所有EL都是以${为起始、以}为结尾的。
     */
    @Value("${environment}")
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
