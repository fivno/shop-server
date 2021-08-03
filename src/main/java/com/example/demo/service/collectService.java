package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.category;

public interface collectService {

    //查

    JSONArray findALL();

    JSONObject findById(int id);

    JSONArray findByUserId(int user_id);

    JSONArray findByProductId(int product_id);


    //增

    boolean insert(JSONObject categoryJSON);    //增加（JSONObject）

    boolean insert(category Category);          //增加（category实体）

    //删

    boolean deleteById(int id);             //根据Id删除

    boolean deleteByUserId(int userId);     //删除该用户user全部收藏夹




    //改



}
