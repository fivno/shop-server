package com.example.demo.service;

import com.example.demo.enity.product;
import com.example.demo.mapper.productMapper;
import com.example.demo.mapper.Product_pictureMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Test
    void testFindAll() {

//        product p=new product();
//        //p.setProduct_id(1);
//        System.out.println(p);
//
//
        Map<String,Object> columnMap=new HashMap<>();
        columnMap.put("product_id",1);
        List<product> list = ProductMapper.selectByMap(columnMap);
        System.out.println(list);
//        List<Product_picture> list2=ppM.selectList(null);
//
//        System.out.println(list2);

    }
}