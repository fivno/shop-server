package com.example.demo.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.product;
import com.example.demo.enity.product_picture;
import com.example.demo.enity.shoppingCart;
import com.example.demo.mapper.productMapper;
import com.example.demo.mapper.shoppingCartMapper;
import com.example.demo.service.shoppingCartService;
import com.example.demo.util.JsonUtil;

@Service
public class shoppingCartServiceImpl implements shoppingCartService{

	@Autowired
    private shoppingCartMapper ShoppingCartMapper;
	
	@Override
	public JSONArray findAllShoppingCart() {
		
		List<shoppingCart> shoppingCartList= ShoppingCartMapper.selectList(null);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(shoppingCartList);

        return allProductJSON;
	}

	@Override
	public JSONObject findById(int id) {

		Map<String,Object> shoppingCartMap = new HashMap<String, Object>();
		
		shoppingCartMap.put("id", id);
		
		List<shoppingCart> shoppingCartList = ShoppingCartMapper.selectByMap(shoppingCartMap);
		
		JSONObject jsonStu = null;
		
		for (shoppingCart shoppingCart : shoppingCartList) {
			String str = JSONObject.toJSONString(shoppingCart);
			jsonStu = JSONObject.parseObject(str);
		}
		
		return jsonStu;
	}

	@Override
	public JSONArray findByUserId(int user_id) {

		Map<String,Object> shoppingCartMap= new HashMap<String, Object>();
		
		shoppingCartMap.put("user_id", user_id);
		
		List<shoppingCart> shoppingCartList = ShoppingCartMapper.selectByMap(shoppingCartMap);
		
		JSONArray allProductJSON=JsonUtil.list2JSONArray(shoppingCartList);
		
		return allProductJSON;
	}

	@Override
	public JSONArray findByProduceId(int product_id) {

		Map<String,Object> shoppingCartMap= new HashMap<String, Object>();
		
		shoppingCartMap.put("product_id", product_id);
		
		List<shoppingCart> shoppingCartList = ShoppingCartMapper.selectByMap(shoppingCartMap);
		
		JSONArray allProductJSON=JsonUtil.list2JSONArray(shoppingCartList);
		
		return allProductJSON;
	}



	@Override
	public boolean insert(JSONObject shoppingCartJSON) {
		
		shoppingCart shoppingCart = JSON.toJavaObject(shoppingCartJSON,shoppingCart.class);
		
		ShoppingCartMapper.insert(shoppingCart);
		
		return true;
	}

	@Override
	public boolean insert(shoppingCart ShoppingCart) {
		
		ShoppingCartMapper.insert(ShoppingCart);
		
		return true;
	}

	@Override
	public boolean updateById() {
		return false;
	}
}
