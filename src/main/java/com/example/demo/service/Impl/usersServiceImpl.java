package com.example.demo.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.enity.product;
import com.example.demo.enity.shoppingCart;
import com.example.demo.enity.users;
import com.example.demo.mapper.shoppingCartMapper;
import com.example.demo.mapper.usersMapper;
import com.example.demo.service.usersService;
import com.example.demo.util.JsonUtil;

@Service
public class usersServiceImpl implements usersService{

	@Autowired
    private usersMapper UsersMapper;

	@Override
	public JSONArray findAll() {
		
		List<users> usersList= UsersMapper.selectList(null);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(usersList);

        return allProductJSON;
	}

	@Override
	public JSONArray findByUserId(int user_id) {

		Map<String,Object> usersMap= new HashMap<String, Object>();
		
		usersMap.put("user_id", user_id);
		
		List<users> usersList = UsersMapper.selectByMap(usersMap);
		
		JSONArray allProductJSON=JsonUtil.list2JSONArray(usersList);
		
		return allProductJSON;
	}



	@Override
	public JSONArray findByUserName(String user_name) {

		QueryWrapper<users> queryWrapper = new QueryWrapper<>();
    	
    	queryWrapper.like(StringUtils.isNotBlank(user_name), "user_name", user_name);
    	
    	List<users> allProduct= UsersMapper.selectList(queryWrapper);
    	
    	JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);
		
		return allProductJSON;
	}

	@Override
	public JSONArray findByPhoneNumber(String user_phoneNumber) {

		QueryWrapper<users> queryWrapper = new QueryWrapper<>();
    	
    	queryWrapper.like(StringUtils.isNotBlank(user_phoneNumber), "user_phone_number", user_phoneNumber);
    	
    	List<users> allProduct= UsersMapper.selectList(queryWrapper);
    	
    	JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);
		
		return allProductJSON;
	}

	@Override
	public boolean insert(JSONObject usersJSON) {
		
		users users = JSON.toJavaObject(usersJSON,users.class);
		
		UsersMapper.insert(users);
		
		return true;
	}

	@Override
	public boolean insert(users usersCart) {
		
		UsersMapper.insert(usersCart);
		
		return true;
	}

}
