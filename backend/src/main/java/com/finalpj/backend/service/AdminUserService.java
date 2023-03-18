package com.finalpj.backend.service;

import java.util.ArrayList;

import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.Criteria;

public interface AdminUserService {

    //테스트출력
    public ArrayList<UserVO> test();

    //리스트 출력
    public ArrayList<UserVO> getList(Criteria cri);

    //페이지네이션용
    public int getTotal(Criteria cri);
    
}
