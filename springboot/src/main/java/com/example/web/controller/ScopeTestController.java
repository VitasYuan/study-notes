package com.example.web.controller;

import com.example.business.scope.PrototypeBean;
import com.example.business.scope.RequestScopeBean;
import com.example.business.scope.SessionScopeBean;
import com.example.business.scope.SingletonBean;
import com.example.business.scope.service.ScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author yuanweipeng
 * @date 2018-02-08
 **/
@RestController
public class ScopeTestController {

    @Autowired
    private List<ScopeService> scopeServiceList;

    @Autowired
    private SingletonBean singletonBean;

    @Autowired
    private PrototypeBean prototypeBean;

    @Autowired
    private RequestScopeBean requestScopeBean;

    @Autowired
    private SessionScopeBean sessionScopeBean;


    @RequestMapping(value = "/scope")
    public String singletonScopeTest(){
        System.out.println("----------start-----------------------");
        System.out.println("SingletonBean in ScopeTestController is : " + singletonBean);
        System.out.println("PrototypeBean in ScopeTestController is : " + prototypeBean);
        System.out.println("RequestScopeBean in ScopeTestController is : " + requestScopeBean);
        System.out.println("SessionScopeBean in ScopeTestController is : " + sessionScopeBean);

        for (ScopeService scopeService : scopeServiceList) {
            scopeService.print();
        }
        System.out.println("----------end-----------------------");
        return "success";
    }

}
