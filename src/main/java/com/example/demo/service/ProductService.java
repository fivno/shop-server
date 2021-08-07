package com.example.demo.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.demo.enity.Product;

public interface ProductService {

    //查询全部产品
    JSONArray findAllProduct();
    JSONArray findByPage(int currentPage,int pageNum);  //当前页，每页个数
    //通过产品id查询
    JSONObject findByProductId(int product_id);

    //通过名字查询（包含模糊查询）
    JSONArray findByName(String name);

    //通过名字查询（包含模糊查询）
    JSONArray findByTitle(String title);

    //通过介绍查询（包含模糊查询）
    JSONArray findByIntro(String intro);


    JSONArray findByCategoryId(int categoryId);

    //增
    boolean insert( JSONObject productJSON);     //增加（JSONObject）
    boolean insert( Product product);     //增加（product实体）
    //删

    boolean deleteById(int id);             //根据id删除（删除一样商品）
    boolean deleteByProductName(int productName);    //根据商品名删除，删除该商品
    boolean deleteByProductId(int Product_id);  //根据商品类id删除，删除该类商品



    //改
    boolean update(Product product, Wrapper<Product> updateWrapper);


    /**
     *
     *用法实例：
     * 修改 商品id=123456 的商品，将其 商品名 productName 改为华为mate40
     * ProductPicture productPicture=new ProductPicture();
     * productPicture.setProductName("华为mate40")；
     *updateByUserPhoneNumber(123456，productPicture)；
     *
     * @param id
     * @param product
     * @return
     */
    boolean updateById(int id, Product product);                       //除id外皆可修改


    /**
     *
     *用法实例：
     * 修改 商品名productName=华为mate40 的商品，将其 商品价格 productPrice 改为5000
     * ProductPicture productPicture=new ProductPicture();
     * productPicture.setProductPrice(5000)；
     *updateByUserPhoneNumber("华为mate40"，productPicture)；
     *
     * @param productName
     * @param product
     * @return
     */
    boolean updateByProductName(String productName, Product product);           //除id，name外皆可修改


}
