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
//图片映射

public class carousel {

	//映射ID
	@TableId(type = IdType.AUTO)
	private Integer carouselId;
	
	//图片路径
	private String imgPath;
	
	//图片描述	
	private String describe;
	
	
	
	
	
	
}
