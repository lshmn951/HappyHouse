package com.ssafy.myapp;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.myapp.model.dto.HouseInfo;
import com.ssafy.myapp.model.service.HouseInfoService;
import com.ssafy.myapp.model.service.PrReviewService;
import com.ssafy.myapp.model.service.UserService;

@SpringBootTest
class HappyHouseFinalApplicationTests {
	
	@Autowired
	UserService uService;
	
	@Autowired
	PrReviewService ps;

	@Autowired
	HouseInfoService his;
	
	
	@Test
	void contextLoads() {
		System.out.println(ps.selectAllByNo(10));
		
	}

}
