package com.ssafy.myapp.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.myapp.model.dto.HouseInfo;
import com.ssafy.myapp.model.dto.HousePageBean;

public interface HouseInfoService {

//	public List<HouseInfo> searchAll(HousePageBean  bean) throws SQLException;

	public HouseInfo search(Map<String, String> map);
//	void insert(HouseInfo houseinfo) ;
//	void update(HouseInfo houseinfo);
//	void delete(int no);
//
//	public void changeName(String string, String string2);
}
