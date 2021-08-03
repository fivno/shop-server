package com.example.demo.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orders {

	private Integer id;
	
	private Integer orderId;
	
	private Integer userId;
	
	private Integer productId;
	
	private Integer productNum;
	
	private Double productPrice;
	
	private Integer orderTime;
	
	
	
	
}
