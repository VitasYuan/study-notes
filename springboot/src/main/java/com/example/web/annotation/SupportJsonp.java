package com.example.web.annotation;

import java.lang.annotation.*;

/**
 * 方法级支持jsonp
 * @author yuanweipeng
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SupportJsonp {
}
