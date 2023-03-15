package com.finalpj.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.finalpj.backend.command.ResumeWriteVO;

@Mapper
public interface ResumeMapper {
    public ArrayList<ResumeWriteVO> ApplyStatus();
    public int ResumeRegist(ResumeWriteVO vo); 
    public List<ResumeWriteVO> ResumeModify();
    public void ResumeUpdate(ResumeWriteVO vo);
    
}
