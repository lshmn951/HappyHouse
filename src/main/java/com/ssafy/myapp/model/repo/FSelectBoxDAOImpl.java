package com.ssafy.myapp.model.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.myapp.model.dto.HouseDeal;
import com.ssafy.myapp.model.dto.HouseInfo;
import com.ssafy.myapp.model.dto.SidoCodeDTO;

@Repository
public class FSelectBoxDAOImpl implements FSelectBoxDAO{

	private static String ns = "com.ssafy.mapper.map.";
	
	@Autowired
	SqlSessionTemplate tmp;

	@Override
	public List<SidoCodeDTO> selectSido() {
		return tmp.selectList(ns+"selectSido");
	}

	@Override
	public List<SidoCodeDTO> selectGugun(String sido) {
		return tmp.selectList(ns+"selectGugun",sido);
	}

	@Override
	public List<HouseInfo> selectDong(String gugun) {
		return tmp.selectList(ns+"selectDong",gugun);
	}

	@Override
	public List<HouseInfo> selectApt(String dong) {
		return tmp.selectList(ns+"selectApt",dong);
	}

	@Override
	public List<HouseDeal> selectAptDeal(String dong) {
		return tmp.selectList(ns+"selectAptDeal",dong);
	}

	@Override
	public List<HouseDeal> selectAptDongName(Map<String, String> map) {
		return tmp.selectList(ns+"selectAptDongName",map);
	}

	
	
	
}
