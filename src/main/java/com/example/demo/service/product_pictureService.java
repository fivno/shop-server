package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface product_pictureService {

    JSONObject findALL();

    JSONObject findById(int id);

    JSONArray findByProductId(int product_id);

    JSONArray findByProductPicture(String product_picture);

}
