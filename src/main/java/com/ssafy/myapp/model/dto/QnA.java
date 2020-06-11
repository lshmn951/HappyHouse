package com.ssafy.myapp.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnA {
	private int qnaNo;
	private String qnaTitle;
	private String qnaContent;
	private String qnaUserid;
	private Date qnaDatetime;
	private String replyContent;
	private Date replyDatetime;
	private String replyUserid;

	
	
}
