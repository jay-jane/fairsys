package com.finalpj.backend.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.service.AdminService;
import com.finalpj.backend.util.Criteria;
import com.finalpj.backend.util.OneGate;
import com.finalpj.backend.util.PageVO;

@RestController
public class AdminController {

    @Autowired
    private AdminService asi;
    
    @GetMapping("/17")
    public Map<String, Integer> adminMain(){

        Map<String, Integer> list = new HashMap<>();

        //전체유저수 
        int total = asi.getTotalUser();
        list.put("totalUser", total);

        //승인된 회사수
        int approveCompany = asi.getApproveCompany();
        list.put("approveCompany", approveCompany);

        System.out.println(total); 

        return list;
    }

    @GetMapping("/20")
    public OneGate<UserVO> getList (Criteria cri){

        System.out.println(cri.toString());

        //페이지네이션 처리
        int total = asi.getTotal(cri);
        System.out.println(total);

        PageVO pageVO = new PageVO(cri, total);
        System.out.println(cri.toString());
         
        //게시글 처리
        ArrayList<UserVO> list =asi.getList(cri);
        OneGate<UserVO> ogate = new OneGate<>(list,pageVO);
 
        //System.out.println(ogate.toString());
        System.out.println(list.toString());

        return ogate;
    };

}
