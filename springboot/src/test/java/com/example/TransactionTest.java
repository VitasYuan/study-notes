package com.example;

import com.example.business.transaction.DictionaryTransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yuanweipeng
 * @date 2018-02-09
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {

    @Autowired
    private DictionaryTransactionService transactionService;

    @Test
    public void transactionTest(){
        transactionService.insertOrUpdate();
    }
}
