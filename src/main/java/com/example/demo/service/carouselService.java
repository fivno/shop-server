package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;

public interface carouselService {

    JSONObject findALL();

    JSONObject findByCarouselId(int carousel_id);

    JSONObject findByImgPath(String findByImgPath);

}
