package com.finalpj.backend.service;

import java.util.ArrayList;
import java.util.List;


import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.command.UserStatusVO;
import com.finalpj.backend.util.ResumeCriteria;


public interface ResumeService {

//  public ArrayList<ResumeWriteVO> ApplyStatus(); //이력서 조회
 public void ResumeRegist(ResumeWriteVO vo);  //이력서 등록
//  public ResumeWriteVO ResumeModify(); //이력서 상세조회

 public List<UserStatusVO> ResumeModify(int user_no); //이력서 상세조회
 
 
 
 
 public void ResumeUpdate(ResumeWriteVO vo); //이력서 수정
 public ArrayList<UserStatusVO> UserMyPage(); //마이페이지
 public void delete(int w_no); //삭제
 public ArrayList<UserStatusVO> getList(ResumeCriteria cri); //이력서 조회
 public int getTotal(ResumeCriteria cri); //페이지네이션
 public void updateStatus(UserStatusVO vo); //진행상황 업데이트
}