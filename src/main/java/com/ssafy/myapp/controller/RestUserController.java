package com.ssafy.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myapp.model.dto.Notice;
import com.ssafy.myapp.model.dto.UserInfo;
import com.ssafy.myapp.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/user")
public class RestUserController {

	@Autowired
	UserService uService;
	
	@ApiOperation(value = "모든 유저의 정보를 반환한다.")
	@GetMapping
	public ResponseEntity<Map<String, Object>> listUser() {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			List<UserInfo> notices = uService.searchAll();
			entity = handleSuccess(notices);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "아이디에 해당하는 유저의 정보를 반환한다.")
	@GetMapping("{userId}")
	public ResponseEntity<Map<String, Object>> searchUser(@PathVariable String userId) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			UserInfo user = uService.search(userId);
			entity = handleSuccess(user);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "회원 가입을 한다.")
	@PostMapping
	public ResponseEntity<Map<String, Object>> registUser(@RequestBody UserInfo user) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			uService.signUp(user);
			entity = handleSuccess("success");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "회원 정보를 수정한다.")
	@PutMapping("{userId}")
	public ResponseEntity<Map<String, Object>> updateUser(@RequestBody UserInfo user) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			uService.update(user);
			entity = handleSuccess(user);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "회원 탈퇴를 한다.")
	@DeleteMapping("{userId}")
	public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable String userId) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			uService.withdraw(userId);
			entity = handleSuccess("success");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "아이디에 해당하는 유저의 자산 정보를 반환한다.")
	@GetMapping("/assets/{userId}")
	public ResponseEntity<Map<String, Object>> searchASUser(@PathVariable String userId) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			UserInfo user = uService.searchAS(userId);
			entity = handleSuccess(user);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@ApiOperation(value = "회원의 자산 정보를 수정한다.")
	@PutMapping("/assets")
	public ResponseEntity<Map<String, Object>> updateASUser(@RequestBody UserInfo user,HttpServletRequest req) {
		
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			System.out.println(user);
			System.out.println(user.getAssets());
			uService.updateAS(user);
			HttpSession session = req.getSession();
			session.setAttribute("userInfo", user);
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
