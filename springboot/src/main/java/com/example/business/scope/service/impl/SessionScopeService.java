package com.example.business.scope.service.impl;

import com.example.business.scope.SessionScopeBean;
import com.example.business.scope.service.ScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanweipeng
 * @date 2018-01-22
 **/
@Service
public class SessionScopeService implements ScopeService {

    @Autowired
    private SessionScopeBean sessionScopeBean;

    @Override
    public void print() {
        System.out.println("SessionScopeBean in SessionScopeService is : " + sessionScopeBean);

    }

}
