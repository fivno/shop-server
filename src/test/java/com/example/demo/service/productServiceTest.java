package com.example.demo.service;

import com.example.demo.enity.product;
import com.example.demo.enity.product_picture;
import com.example.demo.mapper.productMapper;
import com.example.demo.mapper.Product_pictureMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class productServiceTest {


    //productService ProductService;
    @Autowired
    productMapper ProductMapper;

    @Autowired
    Product_pictureMapper ppM;

    @Autowired
    productService ProductService;


    @Test
    void testFindAll() {

        Map<String,Object> mapper=new HashMap<>() ;

        mapper.put("product_id",1);

        System.out.println("FindAProduct_01(JSON)"+ProductMapper.selectByMap(mapper));

        System.out.println("FindALLProduct(JSON)"+ProductService.findAllProduct());


    }
}