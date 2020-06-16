package com.ssafy.myapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myapp.model.dto.UserInfo;
import com.ssafy.myapp.model.repo.UserInfoDao;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserInfoDao dao;

	@Override
	public List<UserInfo> searchAll() {
		return dao.searchAll();
	}

	@Override
	public UserInfo search(String userId) {
		return dao.search(userId);
	}

	@Override
	public int signUp(UserInfo uo) {
		return dao.insert(uo);
	}

	@Override
	public int withdraw(String userId) {
		return dao.delete(userId);
	}

	@Override
	public int update(UserInfo uo) {
		return dao.update(uo);
	}

	@Override
	public UserInfo searchAS(String userId) {
		return dao.searchAS(userId);
	}

	@Override
	public int updateAS(UserInfo uo) {
		return dao.updateAS(uo);
	}

	

}
