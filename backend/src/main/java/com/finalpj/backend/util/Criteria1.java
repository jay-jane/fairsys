// package com.finalpj.backend.util;

// import lombok.Data;

// @Data
// public class Criteria1 {

//     //SQL에 전달할 page, amount를 가지고 다디는 클래스
	
// 	private int page; //조회하는 페이지 번호
// 	private int amount; //데이터 개수
	
// 	//검색키워드 (하영)
// 	private String searchTitle; //제목
// 	private String searchContent; //내용

//     //검색키워드 (재윤)
// 	// private String searchTitle; //기업명
// 	private String searchRegion; //지역
// 	private String searchCareer; //경력
	
// 	public Criteria1() {
// 		this.page = 1;
// 		this.amount = 10;
// 	}

// 	public Criteria1(int page, int amount) {
// 		super();
// 		this.page = page;
// 		this.amount = amount;
// 	}
	
// 	public int getPageStart() {
// 		return (page-1) * amount;
// 	}
    
// }
