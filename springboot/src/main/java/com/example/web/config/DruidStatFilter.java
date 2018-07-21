package com.example.web.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author weipeng_yuan
 * @date 2018-07-21
 */
@WebFilter(
        urlPatterns = "/demo1/*",
        initParams = {
                @WebInitParam(name = "exclusions",value = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*")
        }
)

public class DruidStatFilter extends WebStatFilter {
}
