package com.finalpj.backend.util;

import lombok.Data;

@Data
public class ResumeCriteria {

    //SQL에 전달할 page, amount를 가지고 다디는 클래스
	
	private int page; //조회하는 페이지 번호
	private int amount; //데이터 개수
	
	//검색키워드
	private String searchTitle; //제목
	private String searchStatus; //상태
	private String searchContent; //내용
	
	public ResumeCriteria() {
		this.page = 1;
		this.amount = 10;
	}

	public ResumeCriteria(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}
	
	public int getPageStart() {
		return (page-1) * amount;
	}
    
}
