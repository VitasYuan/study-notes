package com.zjut.controller;

import lombok.Data;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
@Data
public class Response<T> {

    /**
     * 错误码
     */
    private int code = 0;

    /**
     * 错误信息
     */
    private String message = "success";

    /**
     * 返回数据
     */
    private T data;

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
