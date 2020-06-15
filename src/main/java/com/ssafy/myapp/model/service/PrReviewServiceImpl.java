package com.ssafy.myapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myapp.model.dto.PrReview;
import com.ssafy.myapp.model.repo.PrReviewDao;

@Service
public class PrReviewServiceImpl implements PrReviewService{

	@Autowired
	PrReviewDao dao;
	
	@Override
	public List<PrReview> selectAllByNo(int houseNo) {
		return dao.selectAllByNo(houseNo);
	}

	@Override
	public int insert(PrReview review) {
		return dao.insert(review);
	}

	@Override
	public int update(PrReview review) {
		return dao.update(review);
	}

	@Override
	public int delete(int num) {
		return dao.delete(num);
	}
	
}
