package com.ssafy.myapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrReview {
	private int num;
	private String userId;
	private int houseNo;
	private String content;
}
