package com.finalpj.backend.service;

import java.util.ArrayList;

import com.finalpj.backend.command.ResumeVO;
import com.finalpj.backend.command.ResumeWriteVO;


public interface ResumeService {

 public ArrayList<ResumeVO> getList(); //이력서 조회
 public int regist(ResumeWriteVO vo);  //이력서 등록

}