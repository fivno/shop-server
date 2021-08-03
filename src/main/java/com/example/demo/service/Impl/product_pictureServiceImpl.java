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
import com.example.demo.enity.category;
import com.example.demo.enity.orders;
import com.example.demo.enity.product;
import com.example.demo.enity.product_picture;
import com.example.demo.mapper.Product_pictureMapper;
import com.example.demo.mapper.productMapper;
import com.example.demo.service.product_pictureService;
import com.example.demo.util.JsonUtil;

@Service
public class product_pictureServiceImpl implements product_pictureService{

	
	@Autowired
    private Product_pictureMapper product_pictureMapper;
	
	@Override
	public JSONArray findALL() {
		
		List<product_picture>  product_pictureList= product_pictureMapper.selectList(null);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(product_pictureList);

        return allProductJSON;
	}

	@Override
	public JSONObject findById(int id) {

		Map<String,Object> product_pictureMap = new HashMap<String, Object>();
		
		product_pictureMap.put("id", id);
		
		List<product_picture> product_pictureList = product_pictureMapper.selectByMap(product_pictureMap);
		
		JSONObject jsonStu = null;
		
		for (product_picture product_picture : product_pictureList) {
			String str = JSONObject.toJSONString(product_picture);
			jsonStu = JSONObject.parseObject(str);
		}
		
		return jsonStu;
	}

	@Override
	public JSONArray findByProductId(int product_id) {

		Map<String,Object> product_pictureMap = new HashMap<String, Object>();
		
		product_pictureMap.put("product_id", product_id);
		
		List<product_picture> product_pictureList = product_pictureMapper.selectByMap(product_pictureMap);
		
		JSONArray allProductJSON=JsonUtil.list2JSONArray(product_pictureList);
		
		return allProductJSON;
	}

	@Override
	public JSONArray findByProductPicture(String product_picture) {

		QueryWrapper<product_picture> queryWrapper = new QueryWrapper<>();
    	
    	queryWrapper.like(StringUtils.isNotBlank(product_picture), "product_picture", product_picture);
    	
    	List<product_picture> allProduct= product_pictureMapper.selectList(queryWrapper);
    	
    	JSONArray allProductJSON=JsonUtil.list2JSONArray(allProduct);
		
		return allProductJSON;
	}

	@Override
	public boolean insert(JSONObject productPictureJSON) {
		
		product_picture product_picture = JSON.toJavaObject(productPictureJSON,product_picture.class);
		
		product_pictureMapper.insert(product_picture);
		
		return true;
	}

	@Override
	public boolean insert(product_picture productPicture) {
		
		product_pictureMapper.insert(productPicture);
		
		return true;
	}

	@Override
	public boolean deleteById(int id) {
		Map<String,Object> mapper= new HashMap<>();
		mapper.put("id",id);
		product_pictureMapper.deleteByMap(mapper);

		return true;
	}

	@Override
	public boolean deleteByProductId(int ProductId) {
		Map<String,Object> mapper= new HashMap<>();
		mapper.put("product_id",ProductId);
		product_pictureMapper.deleteByMap(mapper);

		return true;
	}

	@Override
	public boolean delete(String productPicture) {
		Map<String,Object> mapper= new HashMap<>();
		mapper.put("product_picture",productPicture);
		product_pictureMapper.deleteByMap(mapper);

		return true;
	}

	@Override
	public boolean updateById(JSONObject productPictureJSON) {
		product_picture ProductPicture=JSON.toJavaObject(productPictureJSON,product_picture.class);

		UpdateWrapper<product_picture> updateWrapper=new UpdateWrapper<>();
		updateWrapper.eq("id",ProductPicture.getId());

		product_pictureMapper.update(ProductPicture,updateWrapper);

		return true;
	}

	@Override
	public boolean update(String productPicture, int productId) {
		Map<String,Object> mapper=new HashMap<>();

		mapper.put("product_picture",productPicture);

		UpdateWrapper<product_picture> updateWrapper=new UpdateWrapper<>();
		updateWrapper.allEq(mapper);

		product_picture ProductPicture=new product_picture();
		ProductPicture.setProductId(productId);
		product_pictureMapper.update(ProductPicture,updateWrapper);

		return true;
	}

}
