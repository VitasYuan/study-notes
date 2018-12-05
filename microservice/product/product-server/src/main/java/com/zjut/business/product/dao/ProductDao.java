package com.zjut.business.product.dao;

import com.zjut.business.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
public interface ProductDao extends JpaRepository<Product, Long> {

    /**
     * 根据状态查询商品列表
     *
     * @param state 商品状态
     * @return 商品列表
     */
    List<Product> findProductsByState(Integer state);

    /**
     * 根据产品id查询产品列表
     *
     * @param productIdList 产品id列表
     * @return 产品列表
     */
    List<Product> findProductsByIdIn(List<Long> productIdList);
}