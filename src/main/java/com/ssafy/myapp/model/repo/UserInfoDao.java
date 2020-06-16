package com.ssafy.myapp.model.repo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.myapp.model.dto.UserInfo;

public interface UserInfoDao {
	
	public List<UserInfo> searchAll() ;
	
	public UserInfo search( String userId);
	
	public int insert(UserInfo uo);
	
	public int delete(String userId);
	
	public int update(UserInfo uo) ;
	
	public UserInfo searchAS(String userId);
	
	public int updateAS(UserInfo uo);
}
