package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.enity.carousel;
import com.example.demo.mapper.carouselMapper;

@Repository
public class carouselDAO {

	@Autowired
	private carouselMapper CM;
	
	public carousel getCarouseById(Integer i) {
		return CM.selectById(i);
	}
	
//	public carousel getCarouseByImgPath(String imgPath) {
//		return CM.;
//	}
	
	
}
