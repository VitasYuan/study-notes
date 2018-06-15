package com.example.business.scope.service.impl;

import com.example.business.scope.PrototypeBean;
import com.example.business.scope.service.ScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanweipeng
 * @date 2018-02-08
 **/
@Service
public class PrototypeScopeService implements ScopeService {

    @Autowired
    private PrototypeBean prototypeBean;

    @Override
    public void print() {
        System.out.println("PrototypeBean in PrototypeScopeService is : " + prototypeBean);
    }

}
