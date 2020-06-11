package com.ssafy.myapp.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myapp.model.dto.HouseDeal;
import com.ssafy.myapp.model.dto.HouseInfo;
import com.ssafy.myapp.model.dto.SidoCodeDTO;
import com.ssafy.myapp.model.repo.FSelectBoxDAO;

@Service
public class FSelectBoxServiceImpl implements FSelectBoxService{

	@Autowired
	FSelectBoxDAO dao;

	@Override
	public List<SidoCodeDTO> selectSido() {
		return dao.selectSido();
	}

	@Override
	public List<SidoCodeDTO> selectGugun(String sido) {
		return dao.selectGugun(sido);
	}

	@Override
	public List<HouseInfo> selectDong(String gugun) {
		return dao.selectDong(gugun);
	}

	@Override
	public List<HouseInfo> selectApt(String dong) {
		return dao.selectApt(dong);
	}

	@Override
	public List<HouseDeal> selectAptDeal(String dong) {
		return dao.selectAptDeal(dong);
	}

	@Override
	public List<HouseDeal> selectAptDongName(Map<String, String> map) {
		return dao.selectAptDongName(map);
	}
	
}
