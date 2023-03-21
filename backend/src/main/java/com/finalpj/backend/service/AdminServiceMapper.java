package com.finalpj.backend.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.Criteria;

@Mapper
public interface AdminServiceMapper {

    //전체유저수 추출
    public int getTotalUser();

    //승인된 회사수 추출
    public int getApproveCompany();
    
    //승인대기 회사수 추출
    public int getWatingCompany();
    
    //유저리스트
    public ArrayList<UserVO> getList(@Param("cri") Criteria cri);

    //페이지네이션용 토탈
    public int getTotal(@Param("cri") Criteria cri);

}
