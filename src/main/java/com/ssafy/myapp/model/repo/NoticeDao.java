package com.ssafy.myapp.model.repo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.myapp.model.dto.Notice;

public interface NoticeDao {
	
	public int insert(Notice notice) ;
	public List<Notice> searchAll();
	public Notice searchByNo(int no);
	public int update(Notice notice);
	public int delete(int no);
}
