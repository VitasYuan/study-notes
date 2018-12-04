package com.zjut.business.order.dao;

import com.zjut.business.order.data.object.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
public interface OrderDetailDao extends JpaRepository<OrderDetail, Long> {
}
