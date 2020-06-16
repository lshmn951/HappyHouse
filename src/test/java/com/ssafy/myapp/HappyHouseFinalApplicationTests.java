package com.ssafy.myapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.myapp.model.dto.HouseDeal;
import com.ssafy.myapp.model.dto.HouseInfo;
import com.ssafy.myapp.model.service.FSelectBoxService;
import com.ssafy.myapp.model.service.HouseInfoService;
import com.ssafy.myapp.model.service.HouseService;
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
	
	@Autowired
	HouseService hs;
	
	@Autowired
	FSelectBoxService fs;
	@Test
	void contextLoads() {
//		HouseDeal hd = hs.search(10);
		Map<String,String> m = new HashMap<>();
//		System.out.println(hd.getDong());
//		if(hd.getDong().charAt(0)==' ') {
//			hd.setDong(hd.getDong().substring(1));
//		}
//		System.out.println(hd.getAptName());
		m.put("dong"," 명륜1가");
		m.put("name","건양하늘터");
		List<HouseDeal> hd = fs.selectAptDongName(m);
		System.out.println(hd);
//		HouseInfo hi = his.search(m);
//		System.out.println(hi);
		
	}

}
