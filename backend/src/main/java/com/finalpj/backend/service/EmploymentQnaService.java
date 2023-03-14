package com.finalpj.backend.service;

import java.util.ArrayList;

import com.finalpj.backend.command.EmploymentQnaVO;
import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.Criteria;

public interface EmploymentQnaService {
    
    //리스트 출력
    public ArrayList<EmploymentQnaVO> getList(String user_id, Criteria cri);

    //페이지네이션용
    public int getTotal(String user_id, Criteria cri);
}
