package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-02-08
 **/
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model){
        return "index";
    }
}
