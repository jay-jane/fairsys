package com.finalpj.backend.service;

import java.util.ArrayList;

import com.finalpj.backend.command.EmploymentQnaVO;
import com.finalpj.backend.util.Criteria;

public interface EmploymentQnaService {
    
    //리스트 출력
    public ArrayList<EmploymentQnaVO> getList(String user_id, Criteria cri);

    //페이지네이션용
    public int getTotal(String user_id, Criteria cri);

    //게시글 상세내용
    public ArrayList<EmploymentQnaVO> getDetail(int qa_no, String user_id);
}
