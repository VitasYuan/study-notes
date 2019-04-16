package com.example.web.listener;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanweipeng
 * @date 2019-04-16
 **/
@WebListener
public class ContextListenerTest implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Map<String, Object> param = new HashMap<>();
        param.put("userName", "ywp");
        param.put("password", "123456");

        //进行加载数据库数据到缓存，比如数据字典
        sce.getServletContext().setAttribute("userInfo", param);
        System.out.println("ContextListenerTest contextDestroyed!");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Object params = sce.getServletContext().getAttribute("userInfo");
        if (params != null) {
            System.out.println(params);
        }
        System.out.println("ContextListenerTest contextInitialized!");

    }
}
