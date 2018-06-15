package com.example.web.controller.dictionary;

import com.example.business.dictionary.service.DictionaryService;
import com.example.business.dictionary.Dictionary;
import com.example.web.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-03-05
 **/
@RestController
@RequestMapping(value = "/static/dictionary")
public class DictionaryController {

    private final Logger LOGGER = LoggerFactory.getLogger(DictionaryController.class);

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping(value = "/list")
    public Response<List<Dictionary>> list(){
        Response<List<Dictionary>> response = new Response<>();
        response.setData(dictionaryService.list());
        LOGGER.info("static/dictionary/list, host is:" + "" + ".seriver_id is:" + "");
        return response;
    }
}
