package com.example.demo.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.Users;

public interface UsersService {

    JSONArray findAll();

    JSONArray findByUserId(int user_id);

    JSONArray findByUserName(String user_name);

    JSONArray findByPhoneNumber(String user_phoneNumber);

    //增
    boolean insert( JSONObject usersJSON);     //增加（JSONObject）
    boolean insert( Users users);     //增加（users实体）

    //删
    boolean deleteByUserId(int i);
    boolean deleteByUserName(String userName);
    boolean deleteByUserPhoneNumber(String phoneNumber);



    //改
    boolean updateById(JSONObject userJSON);
    boolean updateById(int id, Users User);

   boolean updateByUserPhoneNumber(String phoneNumber, Users User);      //根据手机号，可修改用户名和密码

    boolean updateByUserName(String userName, Users User);               //根据用户名，可修改手机号和密码

}
