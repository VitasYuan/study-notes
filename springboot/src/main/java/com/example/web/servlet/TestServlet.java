package com.example.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author yuanweipeng
 * @date 2019-04-16
 **/
@WebServlet(name = "testServlet", urlPatterns = {"/servlet-test"},loadOnStartup = 1)
public class TestServlet extends HttpServlet {

    private transient ServletConfig config;

    @Override
    public void init(ServletConfig config) {
        this.config = config;
        System.out.println("init testServlet");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void destroy() {

    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
