package com.finalpj.backend.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.Criteria;

@Service("AdminUserService")
public class AdminUserServiceImpl implements AdminUserService{
    
    @Autowired
    private AdminUserMapper aum;

    //테스트출력
    public ArrayList<UserVO> test(){
        return aum.test();
    };



    //리스트 출력
    public ArrayList<UserVO> getList(Criteria cri){
        return aum.getList(cri);
    };

    //페이지네이션용
    public int getTotal(Criteria cri){
        return aum.getTotal(cri);
    };
}
