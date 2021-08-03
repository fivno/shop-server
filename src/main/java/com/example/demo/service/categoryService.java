package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;

public interface categoryService {

    JSONObject findALL();

    JSONObject findByCategoryId(int categoryId);

    JSONObject findByCategoryName(String name);


}
