package com.example.business.scope.service.impl;

import com.example.business.scope.service.ScopeService;
import com.example.business.scope.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanweipeng
 * @date 2018-02-08
 **/
@Service
public class SingletonScopeService implements ScopeService {

    @Autowired
    private SingletonBean singletonBean;

    @Override
    public void print() {
        System.out.println("SingletonBean in SingletonScopeService is : " + singletonBean);
    }
}
