package com.zjut.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yuanweipeng
 * @date 2018-12-05
 **/
@Data
public class ProductInfoOutput {

    private long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private int stock;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品icon
     */
    private String icon;

    /**
     * 商品状态,0正常1下架
     */
    private int state;

    /**
     * 商品类别
     */
    private int categoryType;
}
