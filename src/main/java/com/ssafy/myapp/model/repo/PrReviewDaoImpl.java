package com.ssafy.myapp.model.repo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.myapp.model.dto.PrReview;

@Repository
public class PrReviewDaoImpl implements PrReviewDao{
	private static String ns = "com.ssafy.mapper.prReview.";

	@Autowired
	SqlSessionTemplate temp;
	
	@Override
	public List<PrReview> selectAllByNo(int houseNo) {
		return temp.selectList(ns+"selectAllByNo",houseNo);
	}

	@Override
	public int insert(PrReview review) {
		return temp.insert(ns+"insert",review);
	}

	@Override
	public int update(PrReview review) {
		return temp.update(ns+"update",review);
	}

	@Override
	public int delete(int num) {
		return temp.delete(ns+"delete",num);
	}

}
