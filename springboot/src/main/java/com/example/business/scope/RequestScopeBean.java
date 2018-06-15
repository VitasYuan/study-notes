package com.example.business.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


/**
 * 为每个request请求创建一个实例，此模式下自动注入的bean每次请求都为新建一个对象，同一个请求中用到的bean为同一个对象
 * @author yuanweipeng
 * @date 2018-01-22
 **/
@Component
@RequestScope
public class RequestScopeBean {

    private String local;

    private String appKey;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

}
