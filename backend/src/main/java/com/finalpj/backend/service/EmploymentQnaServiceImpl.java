package com.finalpj.backend.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpj.backend.command.EmploymentQnaVO;
import com.finalpj.backend.util.Criteria;

@Service("EmploymentQnaService")
public class EmploymentQnaServiceImpl implements EmploymentQnaService {
    
    @Autowired
    private EmploymentQnaMapper eqm;

    //유저 리스트 출력
    public ArrayList<EmploymentQnaVO> getList(String user_id, Criteria cri){
        return eqm.getList(user_id, cri);
    }

    //기업 리스트 출력
    public ArrayList<EmploymentQnaVO> getCompanyList(String com_id, Criteria cri){
        return eqm.getCompanyList(com_id, cri);
    };

    //유저 토탈  
    public int getTotal(String user_id, Criteria cri){
        return eqm.getTotal(user_id, cri);
    }

    //기업 토탈
    public int getCompanyTotal(String com_id, Criteria cri){
        return eqm.getCompanyTotal(com_id, cri);
    };


    //게시글 상세내용
    public ArrayList<EmploymentQnaVO> getDetail(int qa_no, String user_id){
        return eqm.getDetail(qa_no, user_id);
    }

    //기업게시글 상세내용 요청
    public ArrayList<EmploymentQnaVO> getDetailCompany(int qa_no, String com_id){
        return eqm.getDetailCompany(qa_no, com_id);
    };

    //지원한 회사이름 가져오기
    public ArrayList<String> getComName(String user_id){
        return eqm.getComName(user_id);
    }

    //게시글 작성
    public void regist(EmploymentQnaVO vo){
        eqm.regist(vo);
    }

    //답변등록
    public void registAnswer(EmploymentQnaVO vo){
        System.out.println(vo.toString());

        eqm.registAnswer(vo);
    }

}
