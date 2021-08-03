package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface shoppingCartService {

    JSONArray findAllShoppingCart();

    JSONObject findById(int id);

    JSONArray findByUserId(int user_id);

    JSONArray findByProduceId(int product_id);

}
