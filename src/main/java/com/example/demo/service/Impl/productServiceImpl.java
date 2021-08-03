package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.product;
import com.example.demo.mapper.productMapper;
import com.example.demo.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productServiceImpl implements productService {

    @Autowired
    productMapper ProductMapper;

    @Override
    public JSONArray findAllProduct() {
//        product p=new product();
//        p.setProduct_id(1);





        //System.out.println(allProduct.get(5));


       // JSONArray allProductJSON= new JSONArray();
        //String json= JSON.toJSONString(allProduct.get(1));
       // System.out.println(json);
       // allProductJSON.add(json);

       // return allProductJSON;
        return null;
    }
}
