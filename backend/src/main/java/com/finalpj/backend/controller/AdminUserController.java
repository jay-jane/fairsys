package com.finalpj.backend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.service.AdminUserService;
import com.finalpj.backend.util.Criteria;
import com.finalpj.backend.util.OneGate;
import com.finalpj.backend.util.PageVO;

@RestController
public class AdminUserController {

    @Autowired
    @Qualifier("AdminUserService")
    private AdminUserService aus;

    
    @GetMapping("/20")
    public OneGate<UserVO> getList (Criteria cri){

        //페이지네이션 처리
        int total = aus.getTotal(cri);
        System.out.println(total);
        PageVO pageVO = new PageVO(cri, total);
        //System.out.println(cri.toString());
         
        //게시글 처리
        ArrayList<UserVO> list =aus.getList(cri);
        OneGate<UserVO> ogate = new OneGate<>(list,pageVO);
 
        //System.out.println(ogate.toString());
        System.out.println(list.toString());

        return ogate;
    };

    // @GetMapping("/20")
    // public ArrayList<UserVO> getList(){

    //     System.out.println(1);
    //     ArrayList<UserVO> list = aus.test();
    //     System.out.println(list.toString());

    //     return list;
    // }

}
