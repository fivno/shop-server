package com.example.demo.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.users;

public interface usersService {

    JSONArray findAll();

    JSONArray findByUserId(int user_id);

    JSONArray findByUserName(String user_name);

    JSONArray findByPhoneNumber(String user_phoneNumber);

    //增
    boolean insert( JSONObject usersJSON);     //增加（JSONObject）
    boolean insert( users users);     //增加（users实体）

    //删
    boolean deleteByUserId(int i);




    //改
    boolean updateById(JSONObject userJSON);

   // boolean updateByUserPhoneNumber(String phoneNumber,String);

}
