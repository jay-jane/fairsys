package com.finalpj.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.command.UserStatusVO;
import com.finalpj.backend.util.ResumeCriteria;

@Mapper
public interface ResumeMapper {
    
    public void ResumeRegist(ResumeWriteVO vo); 
    
    // public ResumeWriteVO ResumeModify();
   
    public List<UserStatusVO> ResumeModify(@Param("user_no") int user_no);
    public void ResumeUpdate(ResumeWriteVO vo);
    public ArrayList<UserStatusVO> UserMyPage();
    public void delete(int w_no);
    public int getTotal();
    
    // public ArrayList<ResumeWriteVO> ApplyStatus();
    public ArrayList<UserStatusVO> getList(@Param("cri") ResumeCriteria cri); //리스트조회
    public int getTotal(@Param("cri") ResumeCriteria cri); //페이지네이션

    public void updateStatus(UserStatusVO vo); //진행상황 업데이트
}
