package com.zjut.product.common;

import lombok.Data;

/**
 * @author yuanweipeng
 * @date 2018-12-05
 **/
@Data
public class DecreaseStockInput {

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 产品数量
     */
    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(Long productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
