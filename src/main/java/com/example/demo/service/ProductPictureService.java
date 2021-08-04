package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.ProductPicture;

public interface ProductPictureService {


    //查
    JSONArray findALL();

    JSONObject findById(int id);

    JSONArray findByProductId(int product_id);

    JSONArray findByProductPicture(String product_picture);

    //增
    boolean insert( JSONObject productPictureJSON);     //增加（JSONObject）
    boolean insert( ProductPicture productPicture);     //增加（product_picture实体）

    //删

    boolean deleteById(int id);             //根据id删除（删除一张照片）
    boolean deleteByProductId(int ProductId);    //根据商品id删除（删除该商品全部照片）
    boolean delete(String productPicture); //根据图片名删除


    //改
    boolean updateById(JSONObject productPictureJSON);               //根据id修改
    boolean update(String productPicture,int productId);            //根据图片名修改productId

    boolean updateById(int id, ProductPicture productPicture);       //除id外皆可修改

}
