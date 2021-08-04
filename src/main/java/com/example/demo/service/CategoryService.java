package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.Category;

public interface CategoryService {

    //查
    JSONArray findALL();

    JSONObject findByCategoryId(int categoryId);

    JSONObject findByCategoryName(String name);

    //增
    boolean insert(JSONObject categoryJSON);    //增加（JSONObject）
    boolean insert(Category category);          //增加（category实体）

    //删
    boolean delete(int categoryId);         //根据categoryId删除
    boolean delete(String categoryName);    //根据categoryName删除


    //改
    boolean update(int categoryId,String categoryName); //根据id修改categoryName



}
