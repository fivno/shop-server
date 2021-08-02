package com.example.demo.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orders {

	private Integer id;
	
	private Integer order_id;
	
	private Integer user_id;
	
	private Integer product_id;
	
	private Integer product_num;
	
	private Double product_price;
	
	private Integer order_time;
	
	
	
	
}
