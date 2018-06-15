package com.example.web.controller;

import com.example.business.transaction.DictionaryTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanweipeng
 * @date 2018-02-09
 **/
@RestController
public class TransactionTestController {

    @Autowired
    private DictionaryTransactionService transactionService;

    @RequestMapping(value = "/transaction")
    public String transactionTest(){
        transactionService.insertOrUpdate();
        return "success";
    }
}
