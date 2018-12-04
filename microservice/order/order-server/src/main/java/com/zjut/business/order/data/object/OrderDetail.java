package com.zjut.business.order.data.object;

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
public class OrderDetail {

    /**
     * 自增主键id
     */
    @Id
    @GeneratedValue
    private long id;

    /**
     * 订单id
     */
    private String orderId = "";

    /**
     * 商品id
     */
    private long productId;

    /**
     * 商品名称
     */
    private String productName = "";

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品数量
     */
    private int productQuantity;

    /**
     * 订单总金额
     */
    private String productIcon = "";

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;
}
