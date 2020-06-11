package com.ssafy.myapp.model.repo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.myapp.model.dto.UserInfo;

@Repository
public class UserInfoDaoImpl implements UserInfoDao{
	
	private static String ns = "com.ssafy.mapper.userinfo.";
	
	@Autowired
	SqlSessionTemplate temp;

	@Override
	public List<UserInfo> searchAll() {
		return temp.selectList(ns+"selectAll");
	}

	@Override
	public UserInfo search(String userId) {
		return temp.selectOne(ns+"search",userId);
	}

	@Override
	public int insert(UserInfo uo) {
		return temp.insert(ns+"insert",uo);
	}

	@Override
	public int delete(String userId) {
		return temp.delete(ns+"delete",userId);
	}

	@Override
	public int update(UserInfo uo) {
		return temp.update(ns+"update",uo);
	}

}
