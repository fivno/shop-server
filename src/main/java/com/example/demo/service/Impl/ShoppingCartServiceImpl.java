package com.example.demo.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.enity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.ShoppingCart;
import com.example.demo.mapper.ShoppingCartMapper;
import com.example.demo.service.ShoppingCartService;
import com.example.demo.util.JsonUtil;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
    private ShoppingCartMapper ShoppingCartMapper;
	
	@Override
	public JSONArray findAllShoppingCart() {
		
		List<ShoppingCart> shoppingCartList= ShoppingCartMapper.selectList(null);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(shoppingCartList);

        return allProductJSON;
	}

	@Override
	public JSONArray findByPage(int currentPage,int pageNum) {
		IPage<ShoppingCart> shoppingCartPagePage = new Page<>(currentPage, pageNum);//参数一是当前页，参数二是每页个数

		shoppingCartPagePage = ShoppingCartMapper.selectPage(shoppingCartPagePage,null);

		List<ShoppingCart> list = shoppingCartPagePage.getRecords();

		JSONArray allProductJSON=JsonUtil.list2JSONArray(list);

		return allProductJSON;
	}


	@Override
	public JSONObject findById(int id) {

		Map<String,Object> shoppingCartMap = new HashMap<String, Object>();
		
		shoppingCartMap.put("id", id);
		
		List<ShoppingCart> shoppingCartList = ShoppingCartMapper.selectByMap(shoppingCartMap);
		
		JSONObject jsonStu = null;
		
		for (ShoppingCart shoppingCart : shoppingCartList) {
			String str = JSONObject.toJSONString(shoppingCart);
			jsonStu = JSONObject.parseObject(str);
		}
		
		return jsonStu;
	}

	@Override
	public JSONArray findByUserId(int user_id) {

		Map<String,Object> shoppingCartMap= new HashMap<String, Object>();
		
		shoppingCartMap.put("user_id", user_id);
		
		List<ShoppingCart> shoppingCartList = ShoppingCartMapper.selectByMap(shoppingCartMap);
		
		JSONArray allProductJSON=JsonUtil.list2JSONArray(shoppingCartList);
		
		return allProductJSON;
	}

	@Override
	public JSONArray findByProduceId(int product_id) {

		Map<String,Object> shoppingCartMap= new HashMap<String, Object>();
		
		shoppingCartMap.put("product_id", product_id);
		
		List<ShoppingCart> shoppingCartList = ShoppingCartMapper.selectByMap(shoppingCartMap);
		
		JSONArray allProductJSON=JsonUtil.list2JSONArray(shoppingCartList);
		
		return allProductJSON;
	}






	@Override
	public boolean insert(JSONObject shoppingCartJSON) {
		
		ShoppingCart shoppingCart = JSON.toJavaObject(shoppingCartJSON, ShoppingCart.class);
		
		ShoppingCartMapper.insert(shoppingCart);
		
		return true;
	}

	@Override
	public boolean insert(ShoppingCart shoppingCart) {
		
		ShoppingCartMapper.insert(shoppingCart);
		
		return true;
	}




	@Override
	public boolean update(int userId, int productId, int num) {
		Map<String,Object> mapper=new HashMap<>();
		mapper.put("user_id",userId);
		mapper.put("product_id",productId);

		UpdateWrapper<ShoppingCart> updateWrapper=new UpdateWrapper<>();
		updateWrapper.allEq(mapper);

		ShoppingCart shoppingCart=new ShoppingCart();
		shoppingCart.setNum(num);
		ShoppingCartMapper.update(shoppingCart,updateWrapper);

		return true;
	}

	@Override
	public boolean deleteById(int id) {
		Map<String,Object> mapper= new HashMap<>();
		mapper.put("id",id);
		ShoppingCartMapper.deleteByMap(mapper);

		return true;
	}

	@Override
	public boolean deleteByUserId(int user_id) {
		Map<String,Object> mapper= new HashMap<>();
		mapper.put("user_id",user_id);
		ShoppingCartMapper.deleteByMap(mapper);

		return true;
	}

	@Override
	public boolean deleteByProductId(int product_id) {
		Map<String,Object> mapper= new HashMap<>();
		mapper.put("product_id",product_id);
		ShoppingCartMapper.deleteByMap(mapper);

		return true;
	}

	@Override
	public boolean deleteByUserAndProductId(int userId, int productId) {
		Map<String,Object> mapper=new HashMap<>();
		mapper.put("user_id",userId);
		mapper.put("product_id",productId);


		ShoppingCartMapper.deleteByMap(mapper);

		return true;
	}

	@Override
	public boolean update(int id, int num) {
		ShoppingCart shoppingCart=new ShoppingCart();

		shoppingCart.setNum(num);

		UpdateWrapper<ShoppingCart> updateWrapper=new UpdateWrapper<>();
		updateWrapper.eq("id",id);

		ShoppingCartMapper.update(shoppingCart,updateWrapper);

		return true;
	}



}
