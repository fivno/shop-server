package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.Orders;

public interface OrdersService {

    //查
    JSONArray findALL();

    JSONObject findById(int id);

    JSONArray findByOrderId(int order_id);

    JSONArray findByUserId(int user_id);

    JSONArray findByProductId(int product_id);

    //增
    boolean insert( JSONObject ordersJSON);     //增加（JSONObject）
    boolean insert(Orders order);              //增加（orders实体）



    //删

    boolean deleteById(int id);             //根据id删除（删除订单内所有同一商品）

    boolean deleteByOrderId(int OrderId);    //根据订单id删除
    boolean deleteByUserId(int UserId);     //删除该用户的全部订单
    boolean delete(int orderId,int productId); //删除订单内所有同一商品


    //改

    boolean updateById(JSONObject orderJSON);             //根据id修改信息
    boolean updateById(int id, Orders order);
    boolean update(int orderId,int productId,int num);    //根据订单Id和修改商品数量



}
