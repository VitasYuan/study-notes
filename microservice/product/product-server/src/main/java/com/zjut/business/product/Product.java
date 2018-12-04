package com.zjut.business.product;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@Data
@Entity
public class Product {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue
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

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", state=" + state +
                ", categoryType=" + categoryType +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
