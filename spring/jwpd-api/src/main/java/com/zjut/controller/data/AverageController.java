package com.zjut.controller.data;

import com.zjut.model.AverageValue;
import com.zjut.service.HourAverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author yuanweipeng
 */
@Controller
@RequestMapping(value = "/average")
public class AverageController {

    @Autowired
    private HourAverageService hourAverageService;

    @GetMapping(value = "/hour", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<AverageValue> getHourAverage(@RequestParam(value = "startTime") Date startTime, @RequestParam(value = "endTime") Date endTime){
        List<AverageValue> averageValueList = hourAverageService.get(startTime, endTime);
        return averageValueList;
    }

    @GetMapping(value = "/test-jsp")
    public String page(){
        return "/index.jsp";
    }
}
