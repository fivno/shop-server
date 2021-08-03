package com.example.demo.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class shoppingCart {

	private Integer id;
	
	private Integer userId;
	
	private Integer productId;
	
	private Integer num;
	
	
	
}
