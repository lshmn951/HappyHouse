package com.ssafy.myapp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.myapp.model.dto.UserInfo;
import com.ssafy.myapp.model.repo.QnADao;
import com.ssafy.myapp.model.service.FSelectBoxService;
import com.ssafy.myapp.model.service.UserService;

@SpringBootTest
class HappyHouseWebSpring서울14반고영욱이성현ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	FSelectBoxService fService;
	
	@Autowired
	UserService us;
	@Autowired
	QnADao dao;
	@Test
	void test1() {
		UserInfo user = us.search("ssafy");
		List<UserInfo> ur = us.searchAll();
		System.out.println(ur);
		System.out.println(user.getUserPw());
		System.out.println(dao.select(1));
	}

}

