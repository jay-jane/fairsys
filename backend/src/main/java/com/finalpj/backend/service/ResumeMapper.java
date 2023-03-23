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
    
   
    // public List<UserStatusVO> ResumeModify(@Param("user_no") int user_no);
    public ArrayList<ResumeWriteVO> UserMyPage(String user_id);
    
    
    
    public void ResumeUpdate(ResumeWriteVO vo);  //이력서 수정
    public List<ResumeWriteVO> ResumeModify(@Param("user_no") int user_no); //마이페이지에서 이력서 조회
    public void delete(int user_no); //삭제
    // public ArrayList<ResumeWriteVO> ApplyStatus();
    public ArrayList<UserStatusVO> getList(@Param("cri") ResumeCriteria cri,
                                            @Param("com_id") String com_id); //리스트조회
    public int getTotal(@Param("cri") ResumeCriteria cri,
                        @Param("com_id") String com_id); //페이지네이션

    public void updateStatus(UserStatusVO vo); //진행상황 업데이트
    public List<UserStatusVO> ResumeComModify(@Param("user_no") int user_no); //기업에서  지원자 이력서 조회
}
