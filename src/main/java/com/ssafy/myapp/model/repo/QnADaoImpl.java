package com.ssafy.myapp.model.repo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.myapp.model.dto.QnA;

@Repository
public class QnADaoImpl implements QnADao{
	
	private static String ns = "com.ssafy.myapp.qna.";
	
	@Autowired
	SqlSessionTemplate temp;
	
	@Override
	public List<QnA> selectQnA() {
		return temp.selectList(ns+"selectQnA");
	}

	@Override
	public QnA select(int qnaNo) {
		return temp.selectOne(ns+"select",qnaNo);
	}

	@Override
	public int insert(QnA qna) {
		return temp.insert(ns+"insert",qna);
	}

	@Override
	public int update(QnA qna) {
		return temp.update(ns+"update",qna);
	}

	@Override
	public int delete(int qnaNo) {
		return temp.delete(ns+"delete",qnaNo);
	}

}
