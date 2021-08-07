package com.example.demo;

import com.example.demo.enity.Users;
import com.example.demo.service.UsersService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.enity.ProductPicture;
import com.example.demo.mapper.ProductPictureMapper;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class ShopServerApplicationTests {
	@Autowired
	ProductPictureMapper PM;

	@Autowired
	UsersService usersService;

	@Test
	public void userTest(){
//		Users user=new Users();
//		user.setUserName("qweuqio");
//		user.setPassword("qweuqio");
//		usersService.insert(user);

		if(usersService.isUserNameExisting("46578131")){
			System.out.println("cunzai");
		}
		else{
			System.out.println("bucunzai");
		}
	}


    @Test
    public void contextLoads() {
    	//根据id查询
    	ProductPicture product01=PM.selectById(1);
    	//System.out.println(product01.getProduct_picture());
    	System.out.println("123");
    }





}
