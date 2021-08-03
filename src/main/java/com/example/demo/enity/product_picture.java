package com.example.demo.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class product_picture {

	@TableId(type = IdType.AUTO)
	private Integer id;

	private Integer productId;

	private String productPicture;
	
	private String intro;
	
	
	
}
