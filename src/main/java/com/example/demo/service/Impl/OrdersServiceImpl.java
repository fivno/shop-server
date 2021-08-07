package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.enity.Orders;
import com.example.demo.enity.ProductPicture;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.service.OrdersService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper OrdersMapper;

    @Override
    public JSONArray findALL() {

        List<Orders> ordersList= OrdersMapper.selectList(null);

        JSONArray allProductJSON= JsonUtil.list2JSONArray(ordersList);

        return allProductJSON;
    }

    @Override
    public JSONArray findByPage(int currentPage, int pageNum) {
        IPage<Orders> OrdersPage = new Page<>(currentPage, pageNum);//参数一是当前页，参数二是每页个数

        OrdersPage = OrdersMapper.selectPage(OrdersPage,null);

        List<Orders> list = OrdersPage.getRecords();

        JSONArray allProductJSON=JsonUtil.list2JSONArray(list);

        return allProductJSON;
    }


    @Override
    public JSONObject findById(int id) {

        Map<String,Object> ordersMap = new HashMap<String, Object>();

        ordersMap.put("id", id);

        List<Orders> ordersList = OrdersMapper.selectByMap(ordersMap);

        JSONObject jsonStu = null;

        for (Orders orders : ordersList) {
            String str = JSONObject.toJSONString(orders);
            jsonStu = JSONObject.parseObject(str);
        }

        return jsonStu;
    }

    @Override
    public JSONArray findByOrderId(int order_id) {

        Map<String,Object> ordersMap = new HashMap<String, Object>();

        ordersMap.put("order_id", order_id);

        List<Orders> carouselList = OrdersMapper.selectByMap(ordersMap);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(carouselList);

        return allProductJSON;
    }

    @Override
    public JSONArray findByUserId(int user_id) {

        Map<String,Object> ordersMap = new HashMap<String, Object>();

        ordersMap.put("user_id", user_id);

        List<Orders> carouselList = OrdersMapper.selectByMap(ordersMap);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(carouselList);

        return allProductJSON;
    }

    @Override
    public JSONArray findByProductId(int product_id) {

        Map<String,Object> ordersMap = new HashMap<String, Object>();

        ordersMap.put("product_id", product_id);

        List<Orders> carouselList = OrdersMapper.selectByMap(ordersMap);

        JSONArray allProductJSON=JsonUtil.list2JSONArray(carouselList);

        return allProductJSON;
    }

    @Override
    public boolean insert(JSONObject ordersJSON) {

        Orders Order = JSON.toJavaObject(ordersJSON, Orders.class);

        OrdersMapper.insert(Order);

        return true;
    }

    @Override
    public boolean insert(Orders order) {

        OrdersMapper.insert(order);

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

        Orders Order=JSON.toJavaObject(orderJSON, Orders.class);

        UpdateWrapper<Orders> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",Order.getId());

        OrdersMapper.update(Order,updateWrapper);

        return true;
    }

    @Override
    public boolean updateById(int id, Orders order) {
        UpdateWrapper<Orders> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id);

        OrdersMapper.update(order,updateWrapper);


        return true;
    }

    @Override
    public boolean update(int orderId, int productId, int num) {

        Map<String,Object> mapper=new HashMap<>();
        mapper.put("order_id",orderId);
        mapper.put("product_id",productId);

        UpdateWrapper<Orders> updateWrapper=new UpdateWrapper<>();
        updateWrapper.allEq(mapper);

        Orders Order=new Orders();
        Order.setProductNum(num);
        OrdersMapper.update(Order,updateWrapper);

        return true;
    }




}
