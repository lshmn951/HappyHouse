package com.ssafy.myapp.model.service;

import java.util.List;

import com.ssafy.myapp.model.dto.QnA;

public interface QnAService {
	List<QnA> retrieveQnA();
	QnA select(int qnaNo);
	int insert(QnA qna);
	int update(QnA qna);
	int delete(int qnaNo);
}
