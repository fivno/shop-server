package com.example.demo.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.enity.Users;
import com.example.demo.mapper.usersMapper;
import com.example.demo.service.UsersService;
import com.example.demo.util.JsonUtil;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
    private usersMapper UsersMapper;

	@Override
	public JSONArray findAll() {
		
		List<Users> usersList= UsersMapper.selectList(null);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(usersList);

        return allProductJSON;
	}

	@Override
	public JSONArray findByUserId(int user_id) {

		Map<String,Object> usersMap= new HashMap<String, Object>();
		
		usersMap.put("user_id", user_id);
		
		List<Users> usersList = UsersMapper.selectByMap(usersMap);
		
		JSONArray allProductJSON=JsonUtil.list2JSONArray(usersList);
		
		return allProductJSON;
	}



	@Override
	public JSONArray findByUserName(String user_name) {

		QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
    	
    	queryWrapper.like(StringUtils.isNotBlank(user_name), "user_name", user_name);
    	
    	List<Users> allProduct= UsersMapper.selectList(queryWrapper);
    	
    	JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);
		
		return allProductJSON;
	}

	@Override
	public JSONArray findByPhoneNumber(String user_phoneNumber) {

		QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
    	
    	queryWrapper.like(StringUtils.isNotBlank(user_phoneNumber), "user_phone_number", user_phoneNumber);
    	
    	List<Users> allProduct= UsersMapper.selectList(queryWrapper);
    	
    	JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);
		
		return allProductJSON;
	}

	@Override
	public boolean insert(JSONObject usersJSON) {
		
		Users users = JSON.toJavaObject(usersJSON, Users.class);
		
		UsersMapper.insert(users);
		
		return true;
	}

	@Override
	public boolean insert(Users usersCart) {
		
		UsersMapper.insert(usersCart);
		
		return true;
	}

	@Override
	public boolean deleteByUserId(int user_id) {
		Map<String,Object> mapper= new HashMap<>();
		mapper.put("user_id",user_id);
		UsersMapper.deleteByMap(mapper);

		return true;
	}


	@Override
	public boolean deleteByUserName(String userName) {
		Map<String,Object> mapper= new HashMap<>();
		mapper.put("user_name",userName);
		UsersMapper.deleteByMap(mapper);

		return true;
	}

	@Override
	public boolean deleteByUserPhoneNumber(String phoneNumber) {
		Map<String,Object> mapper= new HashMap<>();
		mapper.put("user_phone_name",phoneNumber);
		UsersMapper.deleteByMap(mapper);

		return true;
	}

	@Override
	public boolean updateById(int id, Users User) {
		UpdateWrapper<Users> updateWrapper=new UpdateWrapper<>();
		updateWrapper.eq("users_id",id);

		UsersMapper.update(User,updateWrapper);
		return true;
	}

	@Override
	public boolean updateById(JSONObject userJSON) {

		Users User = JSON.toJavaObject(userJSON, Users.class);

		UpdateWrapper<Users> updateWrapper=new UpdateWrapper<>();
		updateWrapper.eq("users_id",User.getUserId());

		UsersMapper.update(User,updateWrapper);
		return true;

	}


	@Override
	public boolean updateByUserPhoneNumber(String phoneNumber, Users User) {
		UpdateWrapper<Users> updateWrapper=new UpdateWrapper<>();
		updateWrapper.eq("users_phone_number",phoneNumber);

		UsersMapper.update(User,updateWrapper);
		return true;
	}

	@Override
	public boolean updateByUserName(String userName, Users User) {
		UpdateWrapper<Users> updateWrapper=new UpdateWrapper<>();
		updateWrapper.eq("users_name",userName);

		UsersMapper.update(User,updateWrapper);
		return true;
	}
}
