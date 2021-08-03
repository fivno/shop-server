package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.enity.category;
import com.example.demo.enity.product;
import com.example.demo.mapper.categoryMapper;
import com.example.demo.service.categoryService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class categoryServiceImpl implements categoryService {

    @Autowired
    private categoryMapper CategoryMapper;

    @Override
    public JSONArray findALL() {

        List<category> categoryList= CategoryMapper.selectList(null);

        JSONArray allProductJSON= JsonUtil.list2JSONArray(categoryList);

        return allProductJSON;
    }

    @Override
    public JSONObject findByCategoryId(int categoryId) {

        Map<String,Object> categoryMap = new HashMap<String, Object>();

        categoryMap.put("category_id", categoryId);

        List<category> categoryList = CategoryMapper.selectByMap(categoryMap);

        JSONObject jsonStu = null;

        for (category category : categoryList) {
            String str = JSONObject.toJSONString(category);
            jsonStu = JSONObject.parseObject(str);
        }

        return jsonStu;
    }

    @Override
    public JSONObject findByCategoryName(String name) {

        Map<String,Object> categoryMap = new HashMap<String, Object>();

        categoryMap.put("category_name", name);

        List<category> categoryList = CategoryMapper.selectByMap(categoryMap);

        JSONObject jsonStu = null;

        for (category category : categoryList) {
            String str = JSONObject.toJSONString(category);
            jsonStu = JSONObject.parseObject(str);
        }

        return jsonStu;
    }

    @Override
    public boolean insert(JSONObject categoryJSON) {

        category category = JSON.toJavaObject(categoryJSON,category.class);

        CategoryMapper.insert(category);

        return true;
    }

    @Override
    public boolean insert(category Category) {

        CategoryMapper.insert(Category);

        return true;
    }

    @Override
    public boolean delete(int categoryId) {

        Map<String,Object> mapper= new HashMap<>();
        mapper.put("category_id",categoryId);
        CategoryMapper.deleteByMap(mapper);


        return true;
    }

    @Override
    public boolean delete(String categoryName) {

        Map<String,Object> mapper= new HashMap<>();
        mapper.put("category_name",categoryName);
        CategoryMapper.deleteByMap(mapper);

        return true;
    }

    @Override
    public boolean update(int categoryId, String categoryName) {

        UpdateWrapper<category> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("category_id",categoryId);

        category Category =new category();

        Category.setCategoryName(categoryName);

        CategoryMapper.update(Category,updateWrapper);

        return true;

    }





}
