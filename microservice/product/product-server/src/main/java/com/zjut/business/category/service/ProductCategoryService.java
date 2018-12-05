package com.zjut.business.category.service;

import com.zjut.business.category.ProductCategory;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-12-05
 **/
public interface ProductCategoryService {

    /**
     * 根据类型获取列表
     *
     * @param typeList 类型列表
     * @return 产品列表
     */
    List<ProductCategory> findByTypeIn(List<Integer> typeList);
}
