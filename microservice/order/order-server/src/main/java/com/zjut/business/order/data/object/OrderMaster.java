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
public class OrderMaster {

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
     * 购买人姓名
     */
    private String buyerName = "";

    /**
     * 购买人手机号码
     */
    private String buyerPhone = "";

    /**
     * 购买人地址
     */
    private String buyerAddress = "";

    /**
     * 购买人微信识别码
     */
    private String buyerOpenid = "";

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态
     */
    private int orderStatus;

    /**
     * 支付状态
     */
    private int payStatus;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;
}
