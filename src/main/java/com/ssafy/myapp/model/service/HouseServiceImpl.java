package com.ssafy.myapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myapp.model.dto.HouseDeal;
import com.ssafy.myapp.model.repo.HouseDao;

@Service
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	HouseDao dao;

	@Override
	public HouseDeal search(int no) {
		return dao.search(no);
	}
	

}
