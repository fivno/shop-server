package com.example.demo.service;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.mapper.ProductPictureMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class productServiceTest {


    //productService ProductService;
    @Autowired
    ProductMapper ProductMapper;

    @Autowired
    ProductPictureMapper ppM;

    @Autowired
    com.example.demo.service.ProductService ProductService;


    @Test
    void testFindAll() {

        Map<String,Object> mapper=new HashMap<>() ;

        mapper.put("product_id",1);

        System.out.println("FindAProduct_01(JSON)"+ProductMapper.selectByMap(mapper));

        System.out.println("FindALLProduct(JSON)"+ProductService.findAllProduct());


    }
}