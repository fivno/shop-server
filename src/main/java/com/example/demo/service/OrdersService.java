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


    /**
     *用法实例；
     * 修改 商品id=123456 的订单，将其 商品数目 orderNum 改为1
     * Orders order=new Orders();
     * productPicture.setOrderNum(1)；
     *updateByUserPhoneNumber(123456，productPicture)；
     *
     * @param id
     * @param order
     * @return
     */
    boolean updateById(int id, Orders order);

    /**
     *
     * 根据订单Id和修改商品数量
     *
     * @param orderId
     * @param productId
     * @param num
     * @return
     */
    boolean update(int orderId,int productId,int num);



}
