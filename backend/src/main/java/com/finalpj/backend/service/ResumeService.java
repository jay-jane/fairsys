package com.finalpj.backend.service;

import java.util.ArrayList;
import java.util.List;


import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.command.UserStatusVO;
import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.ResumeCriteria;


public interface ResumeService {

//  public ArrayList<ResumeWriteVO> ApplyStatus(); //이력서 조회
//  public ResumeWriteVO ResumeModify(); //이력서 상세조회




 

 //지원자
public void ResumeRegist(ResumeWriteVO vo);  //지원자 이력서 등록
public void ResumeUpdate(ResumeWriteVO vo); //지원자이력서 수정
public void delete(int user_no); //지원자 이력서 삭제
public ArrayList<UserStatusVO> UserMyPage(String user_id); //지원자마이페이지
public List<ResumeWriteVO> ResumeModify(int user_no); //지원자 마이페이지 이력서 상세조회  
public List<UserVO> getUserVO(String user_id);





//회사

 public ArrayList<UserStatusVO> getList(ResumeCriteria cri, String com_id); //회사에 등록된 이력서 조회
 public int getTotal(ResumeCriteria cri, String com_id); //페이지네이션
 public void updateStatus(UserStatusVO vo); //진행상황 업데이트
 public List<UserStatusVO> ResumeComModify(int user_no); //기업에서 지원자 이력서 상세조회  

}