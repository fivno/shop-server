package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.enity.Category;
import com.example.demo.mapper.categoryMapper;
import com.example.demo.service.CategoryService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private categoryMapper CategoryMapper;

    @Override
    public JSONArray findALL() {

        List<Category> categoryList= CategoryMapper.selectList(null);

        JSONArray allProductJSON= JsonUtil.list2JSONArray(categoryList);

        return allProductJSON;
    }

    @Override
    public JSONObject findByCategoryId(int categoryId) {

        Map<String,Object> categoryMap = new HashMap<String, Object>();

        categoryMap.put("category_id", categoryId);

        List<Category> categoryList = CategoryMapper.selectByMap(categoryMap);

        JSONObject jsonStu = null;

        for (Category category : categoryList) {
            String str = JSONObject.toJSONString(category);
            jsonStu = JSONObject.parseObject(str);
        }

        return jsonStu;
    }

    @Override
    public JSONObject findByCategoryName(String name) {

        Map<String,Object> categoryMap = new HashMap<String, Object>();

        categoryMap.put("category_name", name);

        List<Category> categoryList = CategoryMapper.selectByMap(categoryMap);

        JSONObject jsonStu = null;

        for (Category category : categoryList) {
            String str = JSONObject.toJSONString(category);
            jsonStu = JSONObject.parseObject(str);
        }

        return jsonStu;
    }

    @Override
    public boolean insert(JSONObject categoryJSON) {

        Category category = JSON.toJavaObject(categoryJSON, Category.class);

        CategoryMapper.insert(category);

        return true;
    }

    @Override
    public boolean insert(Category category) {

        CategoryMapper.insert(category);

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

        UpdateWrapper<Category> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("category_id",categoryId);

        Category category =new Category();

        category.setCategoryName(categoryName);

        CategoryMapper.update(category,updateWrapper);

        return true;

    }





}
