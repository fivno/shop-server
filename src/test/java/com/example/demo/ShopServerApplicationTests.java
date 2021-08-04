package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.enity.ProductPicture;
import com.example.demo.mapper.Product_pictureMapper;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class ShopServerApplicationTests {
	@Autowired
	Product_pictureMapper PM;
    @Test
    public void contextLoads() {
    	//根据id查询
    	ProductPicture product01=PM.selectById(1);
    	//System.out.println(product01.getProduct_picture());
    	System.out.println("123");
    }
   

}
