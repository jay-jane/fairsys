package com.finalpj.backend.service;

import java.util.ArrayList;

import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.Criteria;

public interface AdminService {
    

    //전체유저수 추출
    public int getTotalUser();

    //승인된 회사수 추출
    public int getApproveCompany();

    //승인대기 회사수 추출
    public int getWatingCompany();

    

    //유저리스트
    public ArrayList<UserVO> getList(Criteria cri);

    //페이지네이션용 토탈
    public int getTotal(Criteria cri);
}
