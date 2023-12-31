package com.finalpj.backend.util;

import lombok.Data;

@Data
public class JobCriteria {

    //SQL에 전달할 page, amount를 가지고 다니는 클래스
	
	private int page; //조회하는 페이지 번호
	private int amount; //데이터 개수
	
	//검색키워드
	private String searchTitle; //기업명
	private String searchRegion; //지역
	private String searchCareer; //경력
	
	public JobCriteria() {
		this.page = 1;
		this.amount = 10;
	}

	public JobCriteria(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}
	
	public int getPageStart() {
		return (page-1) * amount;
	}
    
}
