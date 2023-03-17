

package com.finalpj.backend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.EmploymentQnaVO;
import com.finalpj.backend.service.EmploymentQnaService;
import com.finalpj.backend.util.Criteria;
import com.finalpj.backend.util.OneGate;
import com.finalpj.backend.util.PageVO;


@RestController
public class EmploymentQnaController {
    
    @Autowired
    private EmploymentQnaService eqs;



    @GetMapping("/11/")
    public  OneGate list (String user_id, Criteria cri){

        //페이지네이션 처리
        int total = eqs.getTotal("aaa123", cri);
        PageVO pageVO = new PageVO(cri, total);
        //System.out.println(cri.toString());
        
       //게시글 처리
        ArrayList<EmploymentQnaVO> list =eqs.getList("aaa123", cri);
        OneGate ogate = new OneGate(list,pageVO);

        //System.out.println(ogate.toString());
        //System.out.println(list.toString());
        return ogate;
    }

    @GetMapping("/12/{qa_no}")
    public ArrayList<EmploymentQnaVO> qnaDetail(@PathVariable("qa_no") int qa_no, 
                            String user_id){
        
        ArrayList<EmploymentQnaVO> list = eqs.getDetail(qa_no, "aaa123");
        //System.out.println(list.toString());

        return list;
    }

    @PostMapping("/13")
    public void write(@RequestBody EmploymentQnaVO vo){
        //System.out.println("실행쓰");
        //System.out.println(vo.toString());
        eqs.regist(vo);
    }
    
    
}
