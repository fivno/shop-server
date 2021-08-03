package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.orders;
import com.example.demo.util.JsonUtil;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@MapperScan("com.example.demo.mapper")
class ordersServiceTest {

    @Autowired
    ordersService OrderService;

    @Test
    void findALL() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByOrderId() {
    }

    @Test
    void findByUserId() {
    }

    @Test
    void findByProductId() {
    }

    @Test
    void insert() {
    }

    @Test
    void testInsert() {
    }

    @Test
    void deleteById() {

        OrderService.deleteById(1);

    }

    @Test
    void deleteByOrderId() {

        OrderService.deleteByOrderId(1);

    }

    @Test
    void deleteByUserId() {
        OrderService.deleteByUserId(1);
    }

    @Test
    void delete() {

        OrderService.delete(1,1);

    }

    @Test
    void updateById() {

        orders Order=new orders();

        Order.setId(1);
        Order.setOrderId(2);
        String json= JSONObject.toJSONString(Order);
        OrderService.updateById(JSONObject.parseObject(json));

        Order.setOrderId(3);

        OrderService.updateById(JsonUtil.Object2JSONObject(Order));


    }

    @Test
    void update() {

        OrderService.update(2,1,100);


    }
}