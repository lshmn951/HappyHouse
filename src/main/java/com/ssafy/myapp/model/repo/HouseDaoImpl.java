package com.ssafy.myapp.model.repo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.myapp.model.dto.HouseDeal;

@Repository
public class HouseDaoImpl implements HouseDao{

	private static String ns= "com.ssafy.mapper.housedeal.";
	@Override
	public HouseDeal search(int no) {
		return temp.selectOne(ns+"search",no);
	} 
	
	@Autowired
	SqlSessionTemplate temp;

}
