package com.example.demo.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

	@TableId(type = IdType.AUTO)
	private Integer id;
	
	private Integer orderId;
	
	private Integer userId;
	
	private Integer productId;
	
	private Integer productNum;
	
	private Double productPrice;
	
	private Integer orderTime;
	
	
	
	
}
