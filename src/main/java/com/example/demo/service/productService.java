package com.example.demo.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.product;
import com.example.demo.enity.product_picture;

public interface productService {

    //查询全部产品
    JSONArray findAllProduct();

    //通过产品id查询
    JSONObject findByProductId(int product_id);

    //通过名字查询（包含模糊查询）
    JSONArray findByName(String name);

    //通过名字查询（包含模糊查询）
    JSONArray findByTitle(String title);

    //通过介绍查询（包含模糊查询）
    JSONArray findByIntro(String intro);

    //增
    boolean insert( JSONObject productJSON);     //增加（JSONObject）
    boolean insert( product Product);     //增加（product实体）
    //删

    //改



}
