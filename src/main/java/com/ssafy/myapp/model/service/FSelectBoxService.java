package com.ssafy.myapp.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.myapp.model.dto.HouseDeal;
import com.ssafy.myapp.model.dto.HouseInfo;
import com.ssafy.myapp.model.dto.SidoCodeDTO;


public interface FSelectBoxService {

	List<SidoCodeDTO> selectSido();

	List<SidoCodeDTO> selectGugun(String sido) ;

	List<HouseInfo> selectDong(String gugun);

	List<HouseInfo> selectApt(String dong);

	List<HouseDeal> selectAptDeal(String dong) ;
	List<HouseDeal> selectAptDongName(Map<String,String> map);
}
