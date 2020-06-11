package com.ssafy.myapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myapp.model.dto.Notice;
import com.ssafy.myapp.model.repo.NoticeDao;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	NoticeDao dao;

	@Override
	public List<Notice> searchAll() {
		return dao.searchAll();
	}

	@Override
	public Notice searchByNo(int no) {
		return dao.searchByNo(no);
	}

	@Override
	public int insert(Notice notice) {
		return dao.insert(notice);
	}

	@Override
	public int delete(int no) {
		return dao.delete(no);
	}

	@Override
	public int update(Notice notice) {
		return dao.update(notice);
	}
	

}
