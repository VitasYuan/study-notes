package com.zjut.controller;

import com.zjut.business.category.ProductCategory;
import com.zjut.business.category.dao.ProductCategoryDao;
import com.zjut.business.category.service.ProductCategoryService;
import com.zjut.business.product.Product;
import com.zjut.business.product.dao.ProductDao;
import com.zjut.business.product.service.ProductService;
import com.zjut.controller.view.object.Response;
import com.zjut.controller.view.object.product.ProductInfoVO;
import com.zjut.controller.view.object.product.ProductVO;
import com.zjut.product.common.DecreaseStockInput;
import com.zjut.product.common.ProductInfoOutput;
import com.zjut.util.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@RestController
@RequestMapping(value = "api/product")
public class ProductApiController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping(value = "/list")
    public Response<ProductVO> list(@RequestParam(value = "state") int state){
        List<Product> products = productService.findProductsByState(state);
        List<Integer> categoryTypeList = new ArrayList<>();
        for (Product product : products) {
            categoryTypeList.add(product.getCategoryType());
        }
        List<ProductCategory> categoryList = productCategoryService.findByTypeIn(categoryTypeList);

        List<ProductVO> result = new ArrayList<>();
        for (ProductCategory category : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(category.getType());
            productVO.setCategoryName(category.getName());

            List<ProductInfoVO> productInfoVOS = new ArrayList<>();

            for (Product product : products) {
                if (product.getCategoryType() == category.getType()) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(product, productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOS);
            result.add(productVO);
        }

        return ResponseUtil.success(result);
    }


    @PostMapping(value = "/list-by-ids")
    public List<ProductInfoOutput> listByIds(@RequestBody List<Long> productIdList){
        return productService.findByIds(productIdList);
    }

    @PostMapping(value = "/decrease-stock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputs){
        productService.decreaseStock(decreaseStockInputs);
    }
}
