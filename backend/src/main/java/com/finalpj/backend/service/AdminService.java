package com.finalpj.backend.service;

import java.util.ArrayList;

import com.finalpj.backend.command.ApplicantsbyDateVO;
import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.Criteria;

public interface AdminService {
    
    //어드민 메인페이지용

    //전체유저수 추출
    public int getTotalUser();

    //승인된 회사수 추출
    public int getApproveCompany();

    //승인대기 회사수 추출
    public int getWatingCompany();

    //최근 7일자별 지원자 추출
    public ArrayList<ApplicantsbyDateVO> getApplicantsbyDate();

    //합격자 중 남성
    public int getPasserMale();

    //합격자 중 여성
    public int getPasserFemale();

    //통계페이지 용//////////////////////////////////////////

    //기간별 가입자
    public ArrayList<ApplicantsbyDateVO> getJoinUser(String ed, String day);

    //기간별 합격자
    public ArrayList<ApplicantsbyDateVO> getPassUser(String ed, String day);

    //기간별 지원자
    public ArrayList<ApplicantsbyDateVO> getApplyUser(String ed, String day);


    //유저리스트
    public ArrayList<UserVO> getList(Criteria cri);

    //페이지네이션용 토탈
    public int getTotal(Criteria cri);
}
