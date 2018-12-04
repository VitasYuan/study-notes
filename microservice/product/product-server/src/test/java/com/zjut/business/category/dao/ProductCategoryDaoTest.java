package com.zjut.business.category.dao;

import com.zjut.business.category.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findByTypeIn() {
        List<Integer> typeList = new ArrayList<>(2);
        typeList.add(11);
//        typeList.add(22);
        List<ProductCategory> list = productCategoryDao.findByTypeIn(typeList);

        System.out.println(list);
    }
}