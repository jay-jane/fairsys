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

    public ArrayList<EmploymentQnaVO> getList(String user_id, Criteria cri){
        return eqm.getList(user_id, cri);
    }

    public int getTotal(String user_id, Criteria cri){
        return eqm.getTotal(user_id, cri);
    }

    //게시글 상세내용
    public ArrayList<EmploymentQnaVO> getDetail(int qa_no, String user_id){
        return eqm.getDetail(qa_no, user_id);
    }

    //게시글 작성
    public void regist(EmploymentQnaVO vo){
        eqm.regist(vo);
    }

}
