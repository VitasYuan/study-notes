package com.zjut.business.product.Exception;

import com.zjut.business.product.ResultEnum;

/**
 * @author yuanweipeng
 * @date 2018-12-05
 **/
public class ProductException extends RuntimeException {

    /**
     * 错误码
     */
    private int code;

    public ProductException() {
    }

    public ProductException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
