package com.finalpj.backend.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpj.backend.command.EmploymentQnaVO;
import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.Criteria;

@Service("EmploymentQnaService")
public class EmploymentQnaMapperImpl implements EmploymentQnaService {
    
    @Autowired
    private EmploymentQnaMapper eqm;

    public ArrayList<EmploymentQnaVO> getList(String user_id, Criteria cri){
        return eqm.getList(user_id, cri);
    }

    public int getTotal(String user_id, Criteria cri){
        return eqm.getTotal(user_id, cri);
    }

}
