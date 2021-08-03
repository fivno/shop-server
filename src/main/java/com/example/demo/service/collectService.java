package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface collectService {

    JSONObject findALL();

    JSONObject findById(int id);

    JSONArray findByUserId(int user_id);

    JSONArray findByProductId(int product_id);

}
