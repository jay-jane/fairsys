package com.finalpj.backend.service;

import java.util.ArrayList;

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
