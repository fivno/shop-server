package com.example.demo.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class category {

	@TableId(type = IdType.AUTO)
	private Integer category_ig;
	
	private String category_name;
	
	
	
}
