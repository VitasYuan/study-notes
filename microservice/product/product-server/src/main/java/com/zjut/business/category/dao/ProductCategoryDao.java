package com.zjut.business.category.dao;

import com.zjut.business.category.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Long> {

    /**
     * 根据类型获取列表
     *
     * @param typeList 类型列表
     * @return 产品列表
     */
    List<ProductCategory> findByTypeIn(List<Integer> typeList);
}
