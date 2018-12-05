package com.zjut.business.order.service.impl;

import com.zjut.OrderApplicationTest;
import com.zjut.business.order.data.object.OrderDetail;
import com.zjut.business.order.dto.OrderDTO;
import com.zjut.business.order.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yuanweipeng
 * @date 2018-12-05
 **/
@Component
public class OrderServiceImplTest extends OrderApplicationTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId(1);
        orderDetail.setProductQuantity(2);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetail);
        orderDTO.setDetailList(orderDetailList);

        orderService.create(orderDTO);
    }
}