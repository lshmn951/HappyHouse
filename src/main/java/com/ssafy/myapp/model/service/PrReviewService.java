package com.ssafy.myapp.model.service;

import java.util.List;

import com.ssafy.myapp.model.dto.PrReview;

public interface PrReviewService {
	List<PrReview> selectAllByNo(int houseNo);
	int insert(PrReview review);
	int update(PrReview review);
	int delete(int num);
}
