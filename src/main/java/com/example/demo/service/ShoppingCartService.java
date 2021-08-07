package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.ShoppingCart;

public interface ShoppingCartService {

    JSONArray findAllShoppingCart();

    JSONArray findByPage(int currentPage,int pageNum);  //当前页，每页个数

    JSONObject findById(int id);

    JSONArray findByUserId(int user_id);

    JSONArray findByProduceId(int product_id);



    //增
    boolean insert( JSONObject shoppingCartJSON);     //增加（JSONObject）
    boolean insert( ShoppingCart shoppingCart);     //增加（shoppingCart实体）


    //删

    boolean deleteById(int id);             //根据id删除（删除一个购物车的所有该商品）
    boolean deleteByUserId(int user_id);    //根据用户id删除，删除该用户全部购物车内容
    boolean deleteByProductId(int product_id);  //根据商品id删除，删除所有用户该商品内容
    boolean deleteByUserAndProductId(int user_id, int product_id); //根据商品id删除，删除某用户某商品内容

    //改

    /**
     *
     * 根据id找到相应订单，修改数量
     *
     * @param id
     * @param num
     * @return
     */
    boolean update(int id,int num);         //根据id修改数量

    /**
     *
     * 根据用户id和产品id找到相应订单，修改商品数量
     *
     * @param userId
     * @param productId
     * @param num
     * @return
     */
    boolean update(int userId, int productId, int num);   //根据用户id和产品id修改购物车该商品数量









}
