package com.zjut.business.product.dao;

import com.zjut.business.ProductApplicationTest;
import com.zjut.business.product.Product;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/

@Component
public class ProductDaoTest extends ProductApplicationTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void findProductsByState() {

        List<Product> productList = productDao.findProductsByState(0);

        Assert.assertTrue(true);

    }
}