package com.example.web.controller;

import com.example.business.dictionary.service.DictionaryService;
import com.example.business.dictionary.Dictionary;
import com.example.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuanweipeng
 * @date 2018-02-08
 **/
@RestController
@RequestMapping(value = "/dictionary")
public class RestApiTest {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping
    public Response<List<Dictionary>> list() {
        Response<List<Dictionary>> response = new Response<>();
        response.setData(dictionaryService.list());
        return response;
    }
}
