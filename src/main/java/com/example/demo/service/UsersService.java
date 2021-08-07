package com.example.demo.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.Users;

import javax.servlet.http.HttpSession;

public interface UsersService {

    JSONArray findAll();
    JSONArray findByPage(int currentPage,int pageNum);  //当前页，每页个数
    JSONArray findByUserId(int user_id);

    //模糊查找
    JSONArray findByUserName(String user_name);

    JSONArray findByPhoneNumber(String user_phoneNumber);


    //准确查找
    Users findByUserNameOne(String userName);

    //增
    boolean insert( JSONObject usersJSON);     //增加（JSONObject）
    boolean insert( Users users);     //增加（users实体）

    //删
    boolean deleteByUserId(int i);
    boolean deleteByUserName(String userName);
    boolean deleteByUserPhoneNumber(String phoneNumber);



    //改

    boolean updateById(JSONObject userJSON);

    /**
     *
     * 用法实例：
     * 修改id=123456的用户，将其地址userAddress改为武汉
     * users User=new users();
     * User.setAdress("武汉")；
     *updateByUserPhoneNumber(123456，User)；
     *
     * @param id
     * @param User
     * @return
     */
    boolean updateById(int id, Users User);


    /**
     * 用法实例：
     * 修改phoneNumber=123456的用户，将其地址userAddress改为武汉
     * users User=new users();
     * User.setAdress("武汉")；
     *updateByUserPhoneNumber("123456"，User)；
     *
     * @param phoneNumber
     * @param User
     * @return boolean
     */
   boolean updateByUserPhoneNumber(String phoneNumber, Users User);      //根据手机号，可修改用户名和密码


    /**
     * 用法实例：
     * 修改userName=xiaoming的用户，讲其地址userAddress改为武汉
     * users User=new users();
     * User.setAddress("武汉")；
     *updateByUserName("小明"，User)；
     *
     * @param userName
     * @param User
     * @return boolean
     */
    boolean updateByUserName(String userName, Users User);               //根据用户名，可修改手机号和密码


    /**
     *
     * @return
     */
    JSONObject login(JSONObject jsonObject);



    JSONObject register(JSONObject jsonObject);


    boolean isUserNameExisting(String userName);




}
