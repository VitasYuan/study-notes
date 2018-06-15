package com.example.web.controller.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yuanweipeng
 * @date 2018-03-28
 **/
@RestController
@RequestMapping(value = "/session")
public class SessionTestController {

    @GetMapping(value = "/test")
    public String test(HttpServletRequest request){
        HttpSession session = request.getSession();

        Object count = session.getAttribute("count");
        if (count == null) {
            session.setAttribute("count", 1);
        } else {
            session.setAttribute("count", (int)count+1);
        }
        System.out.println("count is :" + (int)session.getAttribute("count"));
        return "count is " + session.getAttribute("count");
    }
}
