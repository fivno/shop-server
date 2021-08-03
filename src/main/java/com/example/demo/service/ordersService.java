package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface ordersService {
    JSONObject findALL();

    JSONObject findById(int id);

    JSONArray findByOrderId(int order_id);

    JSONArray findByUserId(int user_id);

    JSONArray findByProductId(int product_id);
}
