package com.example.demo.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class product {

	@TableId(type = IdType.AUTO)
	private Integer product_id;
	
	private String product_name;
	
	private  Integer category_id;
	
	private String product_title;
	
	private String product_intro;
	
	private String product_picture;
	
	private Double product_price;
	
	private Double product_selling_price;
	
	private  Integer product_num;
	
	private  Integer product_sales;
	
	
	
	
	
}
