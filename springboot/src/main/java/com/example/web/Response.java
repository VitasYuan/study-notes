package com.example.web;

/**
 * @author yuanweipeng
 * @date 2018-01-18
 **/
public class Response<T> {

    /**
     * 接口响应代码
     */
    private int code = 200;

    /**
     * 接口访问信息
     */
    private String message = "Success";

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
