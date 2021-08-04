package com.example.demo.service;

import com.example.demo.enity.ProductPicture;
import com.example.demo.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class productPictureServiceTest {

    @Autowired
    ProductPictureService PPS;

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

        ProductPicture pp=new ProductPicture();

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