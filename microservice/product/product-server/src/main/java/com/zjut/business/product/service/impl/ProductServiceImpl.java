package com.zjut.business.product.service.impl;

import com.zjut.business.product.Exception.ProductException;
import com.zjut.business.product.Product;
import com.zjut.business.product.ResultEnum;
import com.zjut.business.product.dao.ProductDao;
import com.zjut.business.product.service.ProductService;
import com.zjut.product.common.DecreaseStockInput;
import com.zjut.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author yuanweipeng
 * @date 2018-12-05
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findProductsByState(Integer state) {
        return productDao.findProductsByState(state);
    }

    @Override
    public List<ProductInfoOutput> findByIds(List<Long> productIdList) {

        List<Product> productList = productDao.findProductsByIdIn(productIdList);

        List<ProductInfoOutput> result = new ArrayList<>(productList.size());
        for (Product product : productList) {
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(product, productInfoOutput);
            result.add(productInfoOutput);
        }

        return result;
    }

    @Override
    public List<Product> decreaseStock(List<DecreaseStockInput> decreaseStockInputs) {

        List<Product> productList = new ArrayList<>();
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputs) {

            //查询商品是否存在
            Optional<Product> productOptional = productDao.findById(decreaseStockInput.getProductId());
            if (!productOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //查询商品库存是否足够
            Product product = productOptional.get();
            int result = product.getStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_NOT_ENOUGH);
            }

            product.setStock(result);
            productDao.save(product);
            productList.add(product);
        }

        return productList;
    }
}
