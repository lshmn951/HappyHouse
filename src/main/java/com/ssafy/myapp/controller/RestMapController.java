package com.ssafy.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ssafy.myapp.model.dto.HouseDeal;
import com.ssafy.myapp.model.dto.HouseInfo;
import com.ssafy.myapp.model.dto.SidoCodeDTO;
import com.ssafy.myapp.model.service.FSelectBoxService;

@RestController
@RequestMapping("/FSelectBoxController")
public class RestMapController {

	@Autowired
	FSelectBoxService fService;
	
	@RequestMapping("/sido")
	private ResponseEntity<Map<String, Object>> sido(HttpServletResponse res){
		ResponseEntity<Map<String, Object>> entity = null;
		res.addHeader("Access-Control-Allow-Origin", "*");
		try {
			List<SidoCodeDTO> list = fService.selectSido();
			JSONArray arr = new JSONArray();
			//System.out.println(list);
			for(SidoCodeDTO dto:list) {
				JSONObject obj = new JSONObject();
				obj.put("sido_code",dto.getSido_code());
				obj.put("sido_name", dto.getSido_name());
				arr.add(obj);
			}
			entity = handleSuccess(arr);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	
	@RequestMapping("/gugun")
	private ResponseEntity<Map<String, Object>> gugun(@RequestParam String sido,HttpServletResponse res){
		ResponseEntity<Map<String, Object>> entity = null;
		res.addHeader("Access-Control-Allow-Origin", "*");

		try {
			List<SidoCodeDTO> list = fService.selectGugun(sido);
			JSONArray arr = new JSONArray();
			//System.out.println(list.get(0));
			for(SidoCodeDTO dto:list) {
				JSONObject obj = new JSONObject();
				obj.put("gugun_code",dto.getGugun_code());
				obj.put("gugun_name", dto.getGugun_name());
				arr.add(obj);
			}
			entity = handleSuccess(arr);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@RequestMapping("/dong")
	private ResponseEntity<Map<String, Object>> dong(@RequestParam String gugun,HttpServletResponse res){
		ResponseEntity<Map<String, Object>> entity = null;
		res.addHeader("Access-Control-Allow-Origin", "*");
		try {
			List<HouseInfo> list = fService.selectDong(gugun);
			JSONArray arr = new JSONArray();
			for(HouseInfo dto:list) {
				JSONObject obj = new JSONObject();
				obj.put("code", dto.getCode());
				obj.put("dong", dto.getDong());
				arr.add(obj);
			}
			entity = handleSuccess(arr);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@RequestMapping("/apt")
	private ResponseEntity<Map<String, Object>> apt(@RequestParam String dong,HttpServletResponse res){
		ResponseEntity<Map<String, Object>> entity = null;
		res.addHeader("Access-Control-Allow-Origin", "*");
		System.out.println(dong);
		try {
			List<HouseDeal> list = fService.selectAptDeal(" "+dong);
			System.out.println(list.get(0).getAptName());
			JSONArray arr = new JSONArray();
			for(HouseDeal dto:list) {
				JSONObject obj = new JSONObject();
				obj.put("no", dto.getNo());
				obj.put("dong", dto.getDong());
				obj.put("AptName", dto.getAptName());
				obj.put("code", dto.getCode());
				obj.put("jibun", dto.getJibun());
				obj.put("dealAmount", dto.getDealAmount());
				arr.add(obj);
			}
			entity = handleSuccess(arr);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@RequestMapping("/aptDongName")
	private ResponseEntity<Map<String, Object>> aptDongName(@RequestParam String dong,@RequestParam String name,HttpServletResponse res){
		ResponseEntity<Map<String, Object>> entity = null;
		res.addHeader("Access-Control-Allow-Origin", "*");
		System.out.println("dong:"+dong);
		System.out.println("namr"+name);
		Map<String, String> map = new HashMap<String, String>();
		map.put("dong", dong);
		map.put("name", name);
		try {
			List<HouseDeal> list = fService.selectAptDongName(map);
			System.out.println(list.get(0).getDong());
			JSONArray arr = new JSONArray();
			for(HouseDeal dto:list) {
				JSONObject obj = new JSONObject();
				obj.put("no", dto.getNo());
				obj.put("dong", dto.getDong());
				obj.put("AptName", dto.getAptName());
				obj.put("code", dto.getCode());
				obj.put("jibun", dto.getJibun());
				obj.put("dealAmount", dto.getDealAmount());
				arr.add(obj);
			}
			entity = handleSuccess(arr);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	private ResponseEntity<Map<String, Object>> handleSuccess(Object data) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", true);
		resultMap.put("data", data);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}

	private ResponseEntity<Map<String, Object>> handleException(Exception e) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", false);
		resultMap.put("data", e.getMessage());
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
