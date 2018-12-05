package com.zjut.business.order.enums;

import lombok.Getter;

/**
 * @author yuanweipeng
 * @date 2018-12-05
 **/
@Getter
public enum OrderStatusEnum {

    /**
     * 新建订单
     */
    NEW(0, "新订单"),

    /**
     * 已完成订单
     */
    FINISHED(1, "完结"),

    /**
     * 已取消订单
     */
    CANCEL(2, "取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
