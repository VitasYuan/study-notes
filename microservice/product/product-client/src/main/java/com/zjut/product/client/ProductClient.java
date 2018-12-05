package com.zjut.product.client;

import com.zjut.product.common.DecreaseStockInput;
import com.zjut.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-12-05
 **/
@FeignClient(name = "product")
public interface ProductClient {

    /**
     * 根据商品id查询商品信息
     *
     * @param productIdList 商品id列表
     * @return 商品信息列表
     */
    @PostMapping(value = "/api/product/list-by-ids")
    List<ProductInfoOutput> listByIds(@RequestBody List<Long> productIdList);

    /**
     * 扣除商品库存
     *
     * @param decreaseStockInputs 减少库存信息列表
     */
    @PostMapping(value = "/api/product/decrease-stock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputs);
}
