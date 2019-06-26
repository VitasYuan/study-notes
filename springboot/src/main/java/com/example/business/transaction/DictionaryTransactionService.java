package com.example.business.transaction;

import com.example.business.dictionary.Dictionary;
import com.example.business.dictionary.dao.impl.DictionaryDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * springboot1.59版本之需要在方法上添加Transactional注解，不需要EnableTransactionManagement注解开启事务功能
 *
 * @author yuanweipeng
 * @date 2018-02-09
 **/
@Service
public class DictionaryTransactionService {

    @Autowired
    private DictionaryDaoImpl dictionaryDao;

    @Transactional(value = "demoServerTransaction", rollbackFor = Exception.class)
    public void insertOrUpdate(){
        //使用事务的时候如何保证缓存一致性
        int id = dictionaryDao.insert(new Dictionary("test","testvalue",1,"test"));
        dictionaryDao.list();
        System.out.println("git test");
        System.out.printf(id + "");
    }


}
