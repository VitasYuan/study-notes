package com.zjut.business.product;

import lombok.Getter;

/**
 * @author yuanweipeng
 * @date 2018-12-05
 **/
@Getter
public enum  ResultEnum {

    /**
     * 商品不存在
     */
    PRODUCT_NOT_EXIST(1, "商品不存在"),

    /**
     * 商品库存不足
     */
    PRODUCT_STOCK_NOT_ENOUGH(2, "商品库存不足");

    /**
     * 返回的错误码
     */
    private int code;

    /**
     * 返回的错误信息
     */
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
