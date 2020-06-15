package com.ssafy.myapp.model.repo;

import java.util.List;

import com.ssafy.myapp.model.dto.PrReview;

public interface PrReviewDao {
	List<PrReview> selectAllByNo(int houseNo);
	int insert(PrReview review);
	int update(PrReview review);
	int delete(int num);
}
