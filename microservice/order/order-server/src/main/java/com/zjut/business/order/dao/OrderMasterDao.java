package com.zjut.business.order.dao;

import com.zjut.business.order.data.object.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
public interface OrderMasterDao extends JpaRepository<OrderMaster, Long> {
}
