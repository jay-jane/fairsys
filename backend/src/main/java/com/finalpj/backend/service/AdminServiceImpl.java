package com.finalpj.backend.service;

import java.util.ArrayList;

import com.finalpj.backend.command.ApplicantsbyDateVO;
import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminServiceMapper asm;

    //전체유저수 추출
    public int getTotalUser(){
        return asm.getTotalUser();
    }

    //승인된 회사수 추출
    public int getApproveCompany(){
        return asm.getApproveCompany();
    };

    //승인대기 회사수 추출
    public int getWatingCompany(){
        return asm.getWatingCompany();
    };

    //최근 7일자별 지원자 추출
    public ArrayList<ApplicantsbyDateVO> getApplicantsbyDate(){
        return asm.getApplicantsbyDate();
    };

    //합격자 중 남성
    public int getPasserMale(){
        return asm.getPasserMale();
    };

    //합격자 중 여성
    public int getPasserFemale(){
        return asm.getPasserFemale();
    };


    //통계페이지 용//////////////////////////////////////////

    public ArrayList<ApplicantsbyDateVO> getJoinUser(String ed, String day){
        return asm.getJoinUser(ed,day);
    };

    //기간별 합격자
    public ArrayList<ApplicantsbyDateVO> getPassUser(String ed, String day){
        return asm.getPassUser(ed, day);
    };

    //기간별 지원자
    public ArrayList<ApplicantsbyDateVO> getApplyUser(String ed, String day){
        return asm.getApplyUser(ed, day);
    };


    //유저리스트
    public ArrayList<UserVO> getList(Criteria cri){
        return asm.getList(cri);
    };

    //페이지네이션용 토탈
    public int getTotal(Criteria cri){
        System.out.println("페토탈작용중");
        return asm.getTotal(cri);
    };
}
