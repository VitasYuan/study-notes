package com.zjut.business.product;

import lombok.Getter;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@Getter
public enum ProductStateEnum {

    /**
     * 商品状态：在架
     */
    UP(0, "在架"),

    /**
     * 商品状态：下架
     */
    DOWN(1, "下架");

    /**
     * 状态码
     */
    private int code;

    /**
     * 信息描述
     */
    private String desc;

    ProductStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
