package com.ssafy.myapp.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myapp.model.dto.UserInfo;

public interface UserService {
	
public List<UserInfo> searchAll();
	
	public UserInfo search(String userId);
	
	public int signUp(UserInfo uo);
	
	public int withdraw(String userId) ;
	
	public int update(UserInfo uo) ;
	
	
}
