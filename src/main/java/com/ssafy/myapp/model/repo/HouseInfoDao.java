package com.ssafy.myapp.model.repo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.myapp.model.dto.HouseInfo;
import com.ssafy.myapp.model.dto.HousePageBean;

public interface HouseInfoDao {

//	public List<HouseInfo> searchAll(HousePageBean bean) throws SQLException;
//
//
//	int insert(Connection connection,HouseInfo houseinfo);
//
//
//	int delete(Connection connection,int no);
//
//	public int update(Connection connection, HouseInfo info);
//	 int changeName(Connection connection, String aptName, String nameToChange) throws SQLException;

	public HouseInfo search(Map<String, String> map) ;

}
