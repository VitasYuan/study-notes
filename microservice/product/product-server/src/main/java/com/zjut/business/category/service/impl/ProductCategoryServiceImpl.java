package com.zjut.business.category.service.impl;

import com.zjut.business.category.ProductCategory;
import com.zjut.business.category.dao.ProductCategoryDao;
import com.zjut.business.category.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-12-05
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> findByTypeIn(List<Integer> typeList) {
        return productCategoryDao.findByTypeIn(typeList);
    }
}
