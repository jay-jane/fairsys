package com.finalpj.backend.service;

import java.util.ArrayList;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.EmploymentQnaVO;
import com.finalpj.backend.util.Criteria;

public interface EmploymentQnaService {
    
    //유저 리스트 출력
    public ArrayList<EmploymentQnaVO> getList(String user_id, Criteria cri);

    //기업 리스트 출력
    public ArrayList<EmploymentQnaVO> getCompanyList(String com_id, Criteria cri);

    //페이지네이션용
    public int getTotal(String user_id, Criteria cri);

    //기업 페이지네이션용
    public int getCompanyTotal(String com_id, Criteria cri);

    //게시글 상세내용
    public ArrayList<EmploymentQnaVO> getDetail(int qa_no, String user_id);

    //기업게시글 상세내용 요청
    public ArrayList<EmploymentQnaVO> getDetailCompany(int qa_no, String com_id);
    
    //지원한 회사이름 가져오기
    public ArrayList<CompanyVO> getComName(String user_id);
    
    
    
    //게시글 작성
    public void regist(EmploymentQnaVO vo);

    //답변등록
    public void registAnswer(EmploymentQnaVO vo);
}