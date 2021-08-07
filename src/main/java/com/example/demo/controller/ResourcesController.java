package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
public class ResourcesController {
    @Autowired
    CarouselService carouselService;
    @RequestMapping(value = {"/carousel"}, method = RequestMethod.GET)
    @ResponseBody
    public JSONArray getRecourse(){

        return carouselService.findALL();

    }
}
