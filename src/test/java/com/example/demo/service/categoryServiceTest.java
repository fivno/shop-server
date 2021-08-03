package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class categoryServiceTest {

    @Autowired
    categoryService CategoryService;

    @Test
    void testMothers() {

        CategoryService.update(9,"23");
        //System.out.println();

    }
}