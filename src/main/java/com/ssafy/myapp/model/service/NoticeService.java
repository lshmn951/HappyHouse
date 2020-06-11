package com.ssafy.myapp.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myapp.model.dto.Notice;

public interface NoticeService {
	public List<Notice> searchAll() ;
	public Notice searchByNo(int no);
	public int insert(Notice notice) ;
	public int delete(int no) ;
	public int update(Notice notice) ;
}
