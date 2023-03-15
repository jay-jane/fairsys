package com.finalpj.backend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.EmploymentQnaVO;
import com.finalpj.backend.service.EmploymentQnaService;
import com.finalpj.backend.util.Criteria;
import com.finalpj.backend.util.PageVO;

@RestController
public class EmploymentQnaController {
    
    @Autowired
    private EmploymentQnaService eqs;

    @GetMapping("/11")
    public  ArrayList<EmploymentQnaVO> list (String user_id, Criteria cri){

        //페이지네이션 처리
        int total = eqs.getTotal("aaa123", cri);
        PageVO pageVO = new PageVO(cri, total);
        System.out.println(cri.toString());
        
        
        ArrayList<EmploymentQnaVO> list =eqs.getList("aaa123", cri);
        //System.out.println(list.toString());
        return list;
    }
    
}
