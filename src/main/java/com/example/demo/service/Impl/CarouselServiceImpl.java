package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.Carousel;
import com.example.demo.mapper.carouselMapper;
import com.example.demo.service.CarouselService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CarouselServiceImpl implements CarouselService {

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

        Carousel carousel= JsonUtil.JSONObject2carousel(carouselJSON);

        CarouselMapper.insert(carousel);


        return true;
    }

    @Override
    public boolean insert(Carousel Carousel) {

        CarouselMapper.insert(Carousel);

        return true;
    }


    @Override
    public boolean updateById(JSONObject carouselJSON) {

        Carousel carousel= JsonUtil.JSONObject2carousel(carouselJSON);

        CarouselMapper.updateById(carousel);

        return true;
    }

    @Override
    public boolean updateById(Carousel carousel) {

        CarouselMapper.updateById(carousel);
        return true;
    }




}
