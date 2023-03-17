package com.finalpj.backend.util;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ResumePageVO {

    //페이지네이션
    //페이지네이션 계산 클래스
	private int start; //첫페이지번호
	private int end;	//끝페이지번호
	private boolean prev; //이전버튼
	private boolean next; //다음버튼
	
	private int page;	//조회하는 번호
	private int amount;	//데이터개수
	private int total;	//전체게시글수
	private int realEnd; //실제끝번호
	
	private ResumeCriteria cri;
	private ArrayList<Integer> pageList; //화면에 반복시킬 페이지
	
	private int pageCount = 10; //페이지네이션개수

	public ResumePageVO(ResumeCriteria cri, int total) {
		
		this.page = cri.getPage();
		this.amount = cri.getAmount();
		this.total = total;
		this.cri = cri;
		
		//끝페이지 번호
		this.end = (int)Math.ceil(this.page/(double)pageCount) * pageCount;
		
		//시작페이지 번호
		this.start = this.end - pageCount + 1;
		
		//실제끝번호
		this.realEnd = (int)Math.ceil( this.total / (double)this.amount); 
		
		//실제끝번호 재계산
		this.end = this.end > this.realEnd ? this.realEnd : this.end;
		
		//이전버튼
		this.prev = this.start > 1;
		
		//다음버튼
		this.next = this.realEnd > this.end;
		
		//화면에서 반복시킬 페이지 데이터
		this.pageList = new ArrayList<>();
		for(int i = this.start; i <= this.end; i++) {
			pageList.add(i);
		}
		
	}

}
