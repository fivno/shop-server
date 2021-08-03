package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.enity.product;
import com.example.demo.mapper.productMapper;
import com.example.demo.service.productService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class productServiceImpl implements productService {

    @Autowired
    productMapper ProductMapper;

    @Override
    public JSONArray findAllProduct() {

        List<product> allProduct= ProductMapper.selectList(null);

        System.out.println(allProduct.get(5));

        JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);

        return allProductJSON;
    }

    @Override
    public JSONObject findByProductId(int product_id) {

        Map<String,Object> productMap = new HashMap<String, Object>();

        productMap.put("product_id", product_id);

        List<product> productList = ProductMapper.selectByMap(productMap);

        JSONObject jsonStu = null;

        for (product product : productList) {
            String str = JSONObject.toJSONString(product);
            jsonStu = JSONObject.parseObject(str);
        }

        return jsonStu;
    }



    @Override
    public JSONArray findByName(String name) {

        QueryWrapper<product> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(name), "product_Name", name);

        List<product> allProduct= ProductMapper.selectList(queryWrapper);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);

        return allProductJSON;

    }

    @Override
    public JSONArray findByTitle(String title) {

        QueryWrapper<product> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(title), "product_title", title);

        List<product> allProduct= ProductMapper.selectList(queryWrapper);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);

        return allProductJSON;

    }

    @Override
    public JSONArray findByIntro(String intro) {

        QueryWrapper<product> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StringUtils.isNotBlank(intro), "product_intro", intro);

        List<product> allProduct= ProductMapper.selectList(queryWrapper);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);

        return allProductJSON;

    }

    @Override
    public boolean insert(JSONObject productJSON) {

        product product = JSON.toJavaObject(productJSON,product.class);

        ProductMapper.insert(product);

        return true;
    }

    @Override
    public boolean insert(product Product) {

        ProductMapper.insert(Product);

        return true;
    }


}
