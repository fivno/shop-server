package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.product_picture;
import com.example.demo.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class product_pictureServiceTest {

    @Autowired
    product_pictureService PPS;

    @Test
    void deleteById() {

        PPS.deleteById(221);



    }

    @Test
    void deleteByProductId() {

        PPS.deleteByProductId(70);
    }

    @Test
    void delete() {

        PPS.delete("zxcv");

    }

    @Test
    void updateById() {

        product_picture pp=new product_picture();

        pp.setId(221);
        pp.setProductId(69);
        pp.setProductPicture("a");


        PPS.updateById(JsonUtil.Object2JSONObject(pp));

    }

    @Test
    void update() {

        PPS.update("a",68);

    }
}