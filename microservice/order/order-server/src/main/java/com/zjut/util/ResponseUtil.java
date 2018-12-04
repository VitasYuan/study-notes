package com.zjut.util;


import com.zjut.controller.Response;

/**
 * @author yuanweipeng
 * @date 2018-12-04
 **/
public class ResponseUtil {

    private ResponseUtil(){}

    public static Response success(Object data){
        Response response = new Response();
        response.setData(data);
        return response;
    }
}
