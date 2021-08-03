package com.example.demo.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface productService {

    //查询全部产品
    JSONArray findAllProduct();

    //通过产品id查询
    JSONArray findByProductId(int product_id);

    //通过名字查询（包含模糊查询）
    JSONArray findByName(String name);

    //通过名字查询（包含模糊查询）
    JSONArray findByTitle(String title);

    //通过名字查询（包含模糊查询）
    JSONArray findByIntro(String intro);

}
