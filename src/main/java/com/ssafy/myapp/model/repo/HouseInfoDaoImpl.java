package com.ssafy.myapp.model.repo;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.myapp.model.dto.HouseInfo;

@Repository
public class HouseInfoDaoImpl implements HouseInfoDao{
	
	private static String ns = "com.ssafy.mapper.houseinfo.";
	
	@Autowired
	SqlSessionTemplate temp;

	@Override
	public HouseInfo search(Map<String, String> map) {
		return temp.selectOne(ns+"search",map);
	}
	
	

}
