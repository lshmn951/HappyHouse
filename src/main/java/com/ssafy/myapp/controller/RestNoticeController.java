package com.ssafy.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myapp.model.dto.Notice;
import com.ssafy.myapp.model.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/notice")
public class RestNoticeController {

	@Autowired
	private NoticeService nService;

	@ApiOperation(value = "모든 공지사항의 정보를 반환한다.")
	@GetMapping
	public ResponseEntity<Map<String, Object>> listNotice() {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			List<Notice> notices = nService.searchAll();
			entity = handleSuccess(notices);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "번호에 해당하는 공지사항의 정보를 반환한다.")
	@GetMapping("{no}")
	public ResponseEntity<Map<String, Object>> searchNotice(@PathVariable int no) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			Notice notice = nService.searchByNo(no);
			entity = handleSuccess(notice);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "공지사항을 등록한다.")
	@PostMapping
	public ResponseEntity<Map<String, Object>> registNotice(@RequestBody Notice notice) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			nService.insert(notice);
			entity = handleSuccess("success");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "공지사항을 등록한다.")
	@PutMapping("{no}")
	public ResponseEntity<Map<String, Object>> updateNotice(@RequestBody Notice notice) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			nService.update(notice);
			entity = handleSuccess("success");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "공지사항을 삭제한다.")
	@DeleteMapping
	public ResponseEntity<Map<String, Object>> deleteNotice(@PathVariable int no) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			nService.delete(no);
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
