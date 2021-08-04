package com.example.demo.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.demo.enity.Product;

public interface ProductService {

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
    boolean insert( Product product);     //增加（product实体）
    //删

    boolean deleteById(int id);             //根据id删除（删除一样商品）
    boolean deleteByProductName(int productName);    //根据商品名删除，删除该商品
    boolean deleteByProductId(int Product_id);  //根据商品类id删除，删除该类商品



    //改
    boolean update(Product product, Wrapper<Product> updateWrapper);
    boolean updateById(int id, Product product);                       //除id外皆可修改
    boolean updateByProductName(String productName, Product product);           //除id，name外皆可修改


}
