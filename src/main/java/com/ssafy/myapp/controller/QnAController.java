package com.ssafy.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myapp.model.dto.QnA;
import com.ssafy.myapp.model.dto.UserInfo;
import com.ssafy.myapp.model.service.QnAService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/qna")
public class QnAController {

	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail"; 
	@Autowired
	private QnAService qnaService;

	@ApiOperation(value = "세션에 저장된 아이디를 반환한다.")
	@GetMapping("/session")
	public ResponseEntity<String> userId(HttpServletRequest req) {
		HttpSession session = req.getSession();
    	UserInfo user = (UserInfo) session.getAttribute("userInfo");
		return new ResponseEntity<String>(user.getUserId(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "모든 게시글의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<QnA>> retrieveQnA() {
		logger.debug("QnA - 호출2");
		return new ResponseEntity<List<QnA>>(qnaService.retrieveQnA(), HttpStatus.OK);
	}

	@ApiOperation(value = "qna번호에 해당하는 qna의 정보를 반환한다.", response = QnAController.class)    
	@GetMapping("{qnaNo}")
	public ResponseEntity<QnA> detailQnA(@PathVariable int qnaNo, HttpServletRequest req) {
		logger.debug("detailqna - 호출");
		return new ResponseEntity<QnA>(qnaService.select(qnaNo), HttpStatus.OK);
	}
	
    @ApiOperation(value = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeQnA(@RequestBody QnA qna,HttpServletRequest req) {
    	HttpSession session = req.getSession();
    	UserInfo user = (UserInfo) session.getAttribute("userInfo");
    	
		logger.debug("writeQna - 호출");
		logger.debug("writeqna - 호출 {}",qna);
		qna.setQnaUserid(user.getUserId());
		if (qnaService.insert(qna)!=0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{qnaNo}")
	public ResponseEntity<String> updateBoard(@RequestBody QnA qna) {
		logger.debug("updateQnA - 호출");
		logger.debug("" + qna);

		if (qnaService.update(qna)>0) {
			System.out.println(qnaService.select(qna.getQnaNo()));
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{qnaNo}")
	public ResponseEntity<String> deleteBoard(@PathVariable int qnaNo) {
		logger.debug("deleteBoard - 호출{}",qnaNo);
		if (qnaService.delete(qnaNo)>0) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}/*
	 */
}