package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.carousel;
import com.example.demo.mapper.carouselMapper;
import com.example.demo.service.carouselService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class carouselServiceImpl implements carouselService {

    @Autowired
    carouselMapper CarouselMapper;

    @Override
    public JSONArray findALL() {
        return null;
    }

    @Override
    public JSONObject findByCarouselId(int carousel_id) {
        return null;
    }

    @Override
    public JSONObject findByImgPath(String findByImgPath) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        CarouselMapper.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByImgPath(String ImgPath) {
        Map<String,Object> mapper=new HashMap<String,Object>();
        mapper.put("imgPath",ImgPath);
        CarouselMapper.deleteByMap(mapper);
        return true;
    }

    @Override
    public boolean insert(JSONObject carouselJSON) {

        carousel Carousel= JsonUtil.JSONObject2carousel(carouselJSON);

        CarouselMapper.insert(Carousel);


        return true;
    }

    @Override
    public boolean insert(carousel Carousel) {

        CarouselMapper.insert(Carousel);

        return true;
    }


    @Override
    public boolean upadateById(JSONObject carouselJSON) {

        carousel Carousel= JsonUtil.JSONObject2carousel(carouselJSON);

        CarouselMapper.updateById(Carousel);

        return true;
    }

    @Override
    public boolean updateById(carousel Carousel) {

        CarouselMapper.updateById(Carousel);
        return true;
    }




}
