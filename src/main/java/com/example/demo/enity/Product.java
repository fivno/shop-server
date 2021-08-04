package com.example.demo.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

	@TableId(type = IdType.AUTO)
	private Integer productId;
	
	private String productName;
	
	private  Integer categoryId;
	
	private String productTitle;
	
	private String productIntro;
	
	private String productPicture;
	
	private Double productPrice;
	
	private Double productSellingPrice;
	
	private  Integer productNum;
	
	private  Integer productSales;
	
	
	
	
	
}
