package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.ProductPicture;

public interface ProductPictureService {


    //查
    JSONArray findALL();
    JSONArray findByPage(int currentPage,int pageNum);  //当前页，每页个数
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


    /**
     *
     *
     * 用法实例：
     * 修改 商品图片名 productPicture=123456 的产品图片，将其 商品id productId 改为2
     * ProductPicture productPicture=new ProductPicture();
     * productPicture.setProductId(2)；
     *updateByUserPhoneNumber(123456，productPicture)；
     *
     * @param productPicture
     * @param productId
     * @return
     */
    boolean update(String productPicture,int productId);            //根据图片名修改productId

    /**
     *
     *
     *用法实例：
     * 修改 商品图片id=123456 的产品图片，将其 商品id productId 改为2
     * ProductPicture productPicture=new ProductPicture();
     * productPicture.setProductId(2)；
     *updateByUserPhoneNumber(123456，productPicture)；
     *
     * @param id
     * @param productPicture
     * @return
     */
    boolean updateById(int id, ProductPicture productPicture);       //除id外皆可修改

}
