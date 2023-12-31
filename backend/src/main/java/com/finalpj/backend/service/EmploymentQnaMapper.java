package com.finalpj.backend.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.EmploymentQnaVO;
import com.finalpj.backend.util.Criteria;

@Mapper
public interface EmploymentQnaMapper {
    
    //리스트 출력
    public ArrayList<EmploymentQnaVO> getList(@Param("user_id") String user_id,
                                              @Param("cri") Criteria cri);
    //기업 리스트 출력
    public ArrayList<EmploymentQnaVO> getCompanyList(@Param("com_id") String com_id,
                                                     @Param("cri") Criteria cri);


    //페이지네이션용
    public int getTotal(@Param("user_id") String user_id,
                        @Param("cri") Criteria cri);

    //기업 페이지네이션용
    public int getCompanyTotal(@Param("com_id") String com_id,
                               @Param("cri") Criteria cri);

    //게시글 상세내용
    public ArrayList<EmploymentQnaVO> getDetail(@Param("qa_no") int qa_no,
                                                @Param("user_id") String user_id);

    //기업게시글 상세내용 요청
    public ArrayList<EmploymentQnaVO> getDetailCompany(@Param("qa_no") int qa_no, 
                                                       @Param("com_id") String com_id);

    //지원한 회사이름 가져오기
    public ArrayList<CompanyVO> getComName(@Param("user_id") String user_id);

    //게시글 작성
    public void regist(EmploymentQnaVO vo);

    //답변등록
    public void registAnswer(EmploymentQnaVO vo);
}
