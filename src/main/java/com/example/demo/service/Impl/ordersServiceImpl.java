package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.enity.category;
import com.example.demo.enity.orders;
import com.example.demo.enity.product;
import com.example.demo.mapper.ordersMapper;
import com.example.demo.service.ordersService;
import com.example.demo.util.JsonUtil;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ordersServiceImpl implements ordersService {

    @Autowired
    private ordersMapper OrdersMapper;

    @Override
    public JSONArray findALL() {

        List<orders> ordersList= OrdersMapper.selectList(null);

        JSONArray allProductJSON= JsonUtil.list2JSONArray(ordersList);

        return allProductJSON;
    }

    @Override
    public JSONObject findById(int id) {

        Map<String,Object> ordersMap = new HashMap<String, Object>();

        ordersMap.put("id", id);

        List<orders> ordersList = OrdersMapper.selectByMap(ordersMap);

        JSONObject jsonStu = null;

        for (orders orders : ordersList) {
            String str = JSONObject.toJSONString(orders);
            jsonStu = JSONObject.parseObject(str);
        }

        return jsonStu;
    }

    @Override
    public JSONArray findByOrderId(int order_id) {

        Map<String,Object> ordersMap = new HashMap<String, Object>();

        ordersMap.put("order_id", order_id);

        List<orders> carouselList = OrdersMapper.selectByMap(ordersMap);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(carouselList);

        return allProductJSON;
    }

    @Override
    public JSONArray findByUserId(int user_id) {

        Map<String,Object> ordersMap = new HashMap<String, Object>();

        ordersMap.put("user_id", user_id);

        List<orders> carouselList = OrdersMapper.selectByMap(ordersMap);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(carouselList);

        return allProductJSON;
    }

    @Override
    public JSONArray findByProductId(int product_id) {

        Map<String,Object> ordersMap = new HashMap<String, Object>();

        ordersMap.put("product_id", product_id);

        List<orders> carouselList = OrdersMapper.selectByMap(ordersMap);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(carouselList);

        return allProductJSON;
    }

    @Override
    public boolean insert(JSONObject ordersJSON) {

        orders Order = JSON.toJavaObject(ordersJSON,orders.class);

        OrdersMapper.insert(Order);

        return true;
    }

    @Override
    public boolean insert(orders Orders) {

        OrdersMapper.insert(Orders);

        return true;
    }

    @Override
    public boolean deleteById(int id) {

        Map<String,Object> mapper= new HashMap<>();
        mapper.put("id",id);
        OrdersMapper.deleteByMap(mapper);

        return true;
    }

    @Override
    public boolean deleteByOrderId(int OrderId) {
        Map<String,Object> mapper= new HashMap<>();
        mapper.put("order_id",OrderId);
        OrdersMapper.deleteByMap(mapper);

        return true;
    }

    @Override
    public boolean deleteByUserId(int UserId) {
        Map<String,Object> mapper= new HashMap<>();
        mapper.put("user_id",UserId);
        OrdersMapper.deleteByMap(mapper);

        return true;
    }

    @Override
    public boolean delete(int orderId, int productId) {
        Map<String,Object> mapper= new HashMap<>();
        mapper.put("order_id",orderId);
        mapper.put("product_id",productId);
        OrdersMapper.deleteByMap(mapper);

        return true;
    }

    @Override
    public boolean updateById(JSONObject orderJSON) {

        orders Order=JSON.toJavaObject(orderJSON,orders.class);

        UpdateWrapper<orders> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",Order.getId());

        OrdersMapper.update(Order,updateWrapper);

        return true;
    }

    @Override
    public boolean update(int orderId, int productId, int num) {

        Map<String,Object> mapper=new HashMap<>();
        mapper.put("order_id",orderId);
        mapper.put("product_id",productId);

        UpdateWrapper<orders> updateWrapper=new UpdateWrapper<>();
        updateWrapper.allEq(mapper);

        orders Order=new orders();
        Order.setProductNum(num);
        OrdersMapper.update(Order,updateWrapper);

        return true;
    }




}
