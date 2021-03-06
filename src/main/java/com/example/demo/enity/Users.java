package com.example.demo.enity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

	@TableId(type = IdType.AUTO)
	private Integer userId;
	
	private String userName;
	
	private String password;

	private String userPhoneNumber;
	
	private String userAddress;
	
	
	
}
