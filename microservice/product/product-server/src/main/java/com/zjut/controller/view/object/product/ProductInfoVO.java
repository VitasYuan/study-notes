package com.zjut.controller.view.object.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@Data
public class ProductInfoVO {

    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品icon
     */
    private String icon;
}
