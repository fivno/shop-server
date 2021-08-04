package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.Carousel;

public interface CarouselService {

    //查
    JSONArray findALL();

    JSONObject findByCarouselId(int carousel_id);

    JSONObject findByImgPath(String ImgPath);


    //删
    boolean deleteById(int id);

    boolean deleteByImgPath(String ImgPath);


    //增
    boolean insert(JSONObject carouselJSON);    //增加（JSONObject）
    boolean insert(Carousel carousel);          //增加（carousel实体）

    //改
    boolean updateById(JSONObject carouselJSON);

    boolean updateById(Carousel carousel);


}
