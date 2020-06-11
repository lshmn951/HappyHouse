package com.ssafy.myapp.model.service;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myapp.model.dto.HouseInfo;
import com.ssafy.myapp.model.repo.HouseInfoDao;

@Service
public class HouseInfoServiceImpl implements HouseInfoService{

	@Autowired
	HouseInfoDao dao;
	
	@Override
	public HouseInfo search(Map<String, String> map) {
		return dao.search(map);
	}

}
