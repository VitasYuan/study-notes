package com.zjut.controller.view.object.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@Data
public class ProductVO {

    /**
     * 类别名称
     */
    @JsonProperty(value = "name")
    private String categoryName;

    /**
     * 类别id
     */
    @JsonProperty(value = "type")
    private Integer categoryType;

    /**
     * 商品信息列表
     */
    @JsonProperty(value = "foods")
    private List<ProductInfoVO> productInfoVOList;

    @Override
    public String toString() {
        return "ProductVO{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                ", productInfoVOList=" + productInfoVOList +
                '}';
    }
}
