package com.ssafy.myapp.model.repo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.myapp.model.dto.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao{
	private static String ns = "com.ssafy.mapper.notice.";
	
	@Autowired
	SqlSessionTemplate temp;

	@Override
	public int insert(Notice notice) {
		return temp.insert(ns+"insert",notice);
	}

	@Override
	public List<Notice> searchAll() {
		return temp.selectList(ns+"selectAll");
	}

	@Override
	public Notice searchByNo(int no) {
		return temp.selectOne(ns+"search",no);
	}

	@Override
	public int update(Notice notice) {
		return temp.update(ns+"update",notice);
	}

	@Override
	public int delete(int no) {
		return temp.delete(ns+"delete",no);
	}
	

}
