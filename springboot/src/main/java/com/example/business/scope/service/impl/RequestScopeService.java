package com.example.business.scope.service.impl;

import com.example.business.scope.RequestScopeBean;
import com.example.business.scope.service.ScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanweipeng
 * @date 2018-01-22
 **/
@Service
public class RequestScopeService implements ScopeService {

    @Autowired
    private RequestScopeBean requestScopeBean;


    @Override
    public void print() {
        System.out.println("RequestScopeBean in RequestScopeService is : " + requestScopeBean);
    }


}
