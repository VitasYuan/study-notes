package com.zjut.business.order.service;

import com.zjut.business.order.dto.OrderDTO;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
public interface OrderService {

    /**
     * 创建订单信息
     *
     * @param orderDTO 订单信息
     * @return 新增的订单信息
     */
    OrderDTO create(OrderDTO orderDTO);
}
