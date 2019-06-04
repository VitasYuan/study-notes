package com.zjut.sign;

/**
 * @author yuanweipeng
 */

public enum SignCheckResponse {
    /**
     * 通过，可以判断为该请求是正常请求
     */
    PASS,
    /**
     * 拒绝，可以判断为该请求是非法请求
     */
    REJECT,
    /**
     * 不能对该请求进行判断，无法判断是否正常请求
     */
    REVIEW
}
