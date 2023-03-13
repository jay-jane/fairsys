package com.finalpj.backend.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.finalpj.backend.command.ResumeVO;
import com.finalpj.backend.command.ResumeWriteVO;

@Mapper
public interface ResumeMapper {
    public ArrayList<ResumeVO> getList();

    public int regist(ResumeWriteVO vo); 
    
}
