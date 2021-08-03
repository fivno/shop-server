package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.product;
import com.example.demo.mapper.productMapper;
import com.example.demo.service.productService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public JSONArray findByProductId(int product_id) {
        return null;
    }

    @Override
    public JSONArray findByName(String name) {
        return null;
    }

    @Override
    public JSONArray findByTitle(String title) {
        return null;
    }

    @Override
    public JSONArray findByIntro(String intro) {
        return null;
    }


}
