package com.ssafy.myapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myapp.model.dto.QnA;
import com.ssafy.myapp.model.repo.QnADao;

@Service
public class QnAServiceImpl implements QnAService{

	@Autowired
	private QnADao dao;
	
	@Override
	public List<QnA> retrieveQnA() {
		return dao.selectQnA();
	}

	@Override
	public QnA select(int qnaNo) {
		// TODO Auto-generated method stub
		return dao.select(qnaNo);
	}

	@Override
	public int insert(QnA qna) {
		// TODO Auto-generated method stub
		return dao.insert(qna);
	}

	@Override
	public int update(QnA qna) {
		// TODO Auto-generated method stub
		return dao.update(qna);
	}

	@Override
	public int delete(int qnaNo) {
		// TODO Auto-generated method stub
		return dao.delete(qnaNo);
	}
	
}
