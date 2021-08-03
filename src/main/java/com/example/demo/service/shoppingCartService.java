package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.product;
import com.example.demo.enity.shoppingCart;

public interface shoppingCartService {

    JSONArray findAllShoppingCart();

    JSONObject findById(int id);

    JSONArray findByUserId(int user_id);

    JSONArray findByProduceId(int product_id);

    boolean updateById();


    //增
    boolean insert( JSONObject shoppingCartJSON);     //增加（JSONObject）
    boolean insert( shoppingCart ShoppingCart);     //增加（shoppingCart实体）


    //删

    //改



}
