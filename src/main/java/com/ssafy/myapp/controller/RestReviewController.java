package com.ssafy.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myapp.model.dto.PrReview;
import com.ssafy.myapp.model.dto.UserInfo;
import com.ssafy.myapp.model.service.PrReviewService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/review")
public class RestReviewController {
	@Autowired
	PrReviewService rService;
	
	@ApiOperation(value = "해당 아파트의 거주 후기를 모두 반환한다.")
	@GetMapping("{houseNo}")
	public ResponseEntity<Map<String, Object>> selectAllByNo(@PathVariable int houseNo) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			List<PrReview> notices = rService.selectAllByNo(houseNo);
			entity = handleSuccess(notices);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}

	
	@ApiOperation(value = "거주 후기를 등록한다.")
	@PostMapping
	public ResponseEntity<Map<String, Object>> registReview(@RequestBody PrReview review) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			rService.insert(review);
			entity = handleSuccess("success");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "거주 후기를 수정한다.")
	@PutMapping
	public ResponseEntity<Map<String, Object>> updateNotice(@RequestBody PrReview review) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			rService.update(review);
			entity = handleSuccess("success");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "거주 후기를 삭제한다.")
	@DeleteMapping("{num}")
	public ResponseEntity<Map<String, Object>> deleteNotice(@PathVariable int num) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			rService.delete(num);
			entity = handleSuccess("success");
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
