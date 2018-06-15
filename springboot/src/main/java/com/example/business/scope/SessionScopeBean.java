package com.example.business.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * 为每个session创建一个实例,测试结果：实例创建和request相同
 * todo 需要具体分析
 * @author yuanweipeng
 * @date 2018-01-22
 **/
@Component
@SessionScope
public class SessionScopeBean {

    private String token;

    private String signature;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
