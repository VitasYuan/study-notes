package com.zjut.business.product.service;

import com.zjut.business.product.Product;
import com.zjut.product.common.DecreaseStockInput;
import com.zjut.product.common.ProductInfoOutput;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-12-05
 **/
public interface ProductService {

    /**
     * 根据状态查询商品列表
     *
     * @param state 商品状态
     * @return 商品列表
     */
    List<Product> findProductsByState(Integer state);

    /**
     * 根据产品id查询产品信息
     *
     * @param productIdList 产品id列表
     * @return 产品信息列表
     */
    List<ProductInfoOutput> findByIds(List<Long> productIdList);

    /**
     * 减少库存,todo 需要添加事务
     *
     * @param decreaseStockInputs 扣除库存信息列表
     * @return 扣除库存后的产品列表
     */
    List<Product> decreaseStock(List<DecreaseStockInput> decreaseStockInputs);
}
