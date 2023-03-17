package com.finalpj.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.util.ResumeCriteria;

@Mapper
public interface ResumeMapper {
    
    public int ResumeRegist(ResumeWriteVO vo); 
    
    // public ResumeWriteVO ResumeModify();
   
    public List<ResumeWriteVO> ResumeModify();
    public void ResumeUpdate(ResumeWriteVO vo);
    public ArrayList<ResumeWriteVO> UserMyPage();
    public void delete(int w_no);
    public int getTotal();
    
    // public ArrayList<ResumeWriteVO> ApplyStatus();
    public ArrayList<ResumeWriteVO> getList(@Param("cri") ResumeCriteria cri); //리스트조회
    public int getTotal(@Param("cri") ResumeCriteria cri); //페이지네이션
}

;