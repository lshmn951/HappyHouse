package com.ssafy.myapp.model.repo;

import java.util.List;

import com.ssafy.myapp.model.dto.QnA;


public interface QnADao {
	public List<QnA> selectQnA();
	public QnA select(int qnaNo);
	public int insert(QnA qna);
	public int update(QnA qna);
	public int delete(int qnaNo);
}
