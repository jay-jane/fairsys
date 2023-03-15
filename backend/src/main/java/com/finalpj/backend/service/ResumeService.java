package com.finalpj.backend.service;

import java.util.ArrayList;
import java.util.List;


import com.finalpj.backend.command.ResumeWriteVO;


public interface ResumeService {

 public ArrayList<ResumeWriteVO> ApplyStatus(); //이력서 조회
 public int ResumeRegist(ResumeWriteVO vo);  //이력서 등록
 public List<ResumeWriteVO> ResumeModify(); //이력서 상세조회
 public void ResumeUpdate(ResumeWriteVO vo); //이력서 수정


}