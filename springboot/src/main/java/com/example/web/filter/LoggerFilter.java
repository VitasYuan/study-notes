package com.example.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author yuanweipeng
 * @date 2019-04-16
 **/
@WebFilter(filterName = "logFilter", urlPatterns = {"/*"})
public class LoggerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

    }

    @Override
    public void destroy() {

    }
}
