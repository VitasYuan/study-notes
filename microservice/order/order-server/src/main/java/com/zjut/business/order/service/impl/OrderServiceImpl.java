package com.zjut.business.order.service.impl;

import com.zjut.business.order.dao.OrderDetailDao;
import com.zjut.business.order.dao.OrderMasterDao;
import com.zjut.business.order.data.object.OrderDetail;
import com.zjut.business.order.data.object.OrderMaster;
import com.zjut.business.order.dto.OrderDTO;
import com.zjut.business.order.enums.OrderStatusEnum;
import com.zjut.business.order.enums.PayStatusEnum;
import com.zjut.business.order.service.OrderService;
import com.zjut.product.client.ProductClient;
import com.zjut.product.common.DecreaseStockInput;
import com.zjut.product.common.ProductInfoOutput;
import com.zjut.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        List<OrderDetail> orderDetailList = orderDTO.getDetailList();
        List<Long> productIdList = new ArrayList<>();
        String orderId = KeyUtil.genUniqueKey();

        List<DecreaseStockInput> decreaseStockInputs = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetailList) {
            productIdList.add(orderDetail.getProductId());
            decreaseStockInputs.add(new DecreaseStockInput(orderDetail.getProductId(), orderDetail.getProductQuantity()));
        }
        List<ProductInfoOutput> productInfoOutputs = productClient.listByIds(productIdList);

        BigDecimal sumAmount = new BigDecimal(BigInteger.ZERO);

        Date now = new Date();
        for (OrderDetail orderDetail : orderDetailList) {
            for (ProductInfoOutput productInfoOutput : productInfoOutputs) {
                if (productInfoOutput.getId() == orderDetail.getProductId()) {
                    sumAmount = sumAmount.add(productInfoOutput.getPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())));
                    BeanUtils.copyProperties(productInfoOutput, orderDetail);

                    orderDetail.setProductId(productInfoOutput.getId());
                    orderDetail.setProductPrice(productInfoOutput.getPrice());
                    orderDetail.setProductName(productInfoOutput.getName());
                    orderDetail.setProductIcon(productInfoOutput.getIcon());
                    orderDetail.setOrderId(orderId);
                    orderDetail.setCreatedTime(now);
                    orderDetail.setUpdatedTime(now);
                    orderDetailDao.save(orderDetail);
                }
            }
        }
        //扣库存（商品项目）
        productClient.decreaseStock(decreaseStockInputs);
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(sumAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreatedTime(now);
        orderMaster.setUpdatedTime(now);
        orderMasterDao.save(orderMaster);
        return orderDTO;
    }
}
