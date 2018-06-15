package com.example;

import com.example.business.dictionary.dao.DictionaryDao;
import com.example.business.dictionary.dao.impl.DictionaryDaoImpl;
import com.example.business.user.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yuanweipeng
 * @date 2018-03-08
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoUserDbTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DictionaryDaoImpl dictionaryDaoImpl;

    @Autowired
    private DictionaryDao dictionaryDao;

    @Test
    public void test(){
//        System.out.println(userDao.list());
//
//        System.out.println(dictionaryDao.list());
//        System.out.println(userDao.list());
//        dictionaryDao.list();
        System.out.println(dictionaryDao.getId());

    }
}
