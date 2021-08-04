package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.enity.Product;
import com.example.demo.mapper.productMapper;
import com.example.demo.service.ProductService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    productMapper ProductMapper;

    @Override
    public JSONArray findAllProduct() {

        List<Product> allProduct= ProductMapper.selectList(null);

        System.out.println(allProduct.get(5));

        JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);

        return allProductJSON;
    }

    @Override
    public JSONObject findByProductId(int product_id) {

        Map<String,Object> productMap = new HashMap<String, Object>();

        productMap.put("product_id", product_id);

        List<Product> productList = ProductMapper.selectByMap(productMap);

        JSONObject jsonStu = null;

        for (Product product : productList) {
            String str = JSONObject.toJSONString(product);
            jsonStu = JSONObject.parseObject(str);
        }

        return jsonStu;
    }



    @Override
    public JSONArray findByName(String name) {

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(name), "product_Name", name);

        List<Product> allProduct= ProductMapper.selectList(queryWrapper);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);

        return allProductJSON;

    }

    @Override
    public JSONArray findByTitle(String title) {

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(title), "product_title", title);

        List<Product> allProduct= ProductMapper.selectList(queryWrapper);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);

        return allProductJSON;

    }

    @Override
    public JSONArray findByIntro(String intro) {

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(intro), "product_intro", intro);

        List<Product> allProduct= ProductMapper.selectList(queryWrapper);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);

        return allProductJSON;

    }

    @Override
    public boolean insert(JSONObject productJSON) {

        Product product = JSON.toJavaObject(productJSON, Product.class);

        ProductMapper.insert(product);

        return true;
    }

    @Override
    public boolean insert(Product product) {

        ProductMapper.insert(product);

        return true;
    }

    @Override
    public boolean deleteById(int id) {
        Map<String,Object> mapper= new HashMap<>();
        mapper.put("id",id);
        ProductMapper.deleteByMap(mapper);

        return true;
    }

    @Override
    public boolean deleteByProductName(int productName) {
        Map<String,Object> mapper= new HashMap<>();
        mapper.put("product_name",productName);
        ProductMapper.deleteByMap(mapper);

        return true;
    }

    @Override
    public boolean deleteByProductId(int product_id) {
        Map<String,Object> mapper= new HashMap<>();
        mapper.put("product_name",product_id);
        ProductMapper.deleteByMap(mapper);

        return true;
    }

    @Override
    public boolean update(Product product, Wrapper<Product> updateWrapper) {

        ProductMapper.update(product,updateWrapper);

        return true;
    }

    @Override
    public boolean updateById(int id, Product product) {
        UpdateWrapper<com.example.demo.enity.Product> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id);

        ProductMapper.update(product,updateWrapper);
        return true;
    }

    @Override
    public boolean updateByProductName(String productName, Product product) {
        UpdateWrapper<com.example.demo.enity.Product> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("product_name",productName);

        ProductMapper.update(product,updateWrapper);
        return true;
    }


}
