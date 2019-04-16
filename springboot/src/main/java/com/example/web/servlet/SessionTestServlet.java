package com.example.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author yuanweipeng
 * @date 2019-04-16
 **/
@WebServlet(name = "sessionTestServlet", urlPatterns = {"/session-test"},loadOnStartup = 1)
public class SessionTestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        if (session != null) {
            Integer count = (Integer) session.getAttribute("count");
            if (count == null) {
                session.setAttribute("count", 1);
                resp.getWriter().write(1+"");

            } else {
                session.setAttribute("count", ++count);
                resp.getWriter().write(count+"");
            }
        }

        Cookie[] cookies = req.getCookies();
        StringBuffer sb = new StringBuffer();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                sb.append(cookie.getName() + "=" + cookie.getValue());
            }

        }

        System.out.println("第" + session.getAttribute("count") + "访问!" + "cookie:" + sb.toString());
        System.out.println("第" + session.getAttribute("count") + "访问!" + " header-Set-Cookie:" + resp.getHeader("Set-Cookie"));


    }
}
