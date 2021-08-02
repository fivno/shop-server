package com.example.demo.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class shoppingCart {

	private Integer id;
	
	private Integer user_id;
	
	private Integer product_id;
	
	private Integer num;
	
	
	
}
