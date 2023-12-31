package com.finalpj.backend.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.ApplicantsbyDateVO;
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
    public Map<String, Object> adminMain(){

        Map<String, Object> map = new HashMap<>();

        //전체유저수 
        int total = asi.getTotalUser();
        map.put("totalUser", total);
        System.out.println("유저수"+total);

        //승인된 기업수
        int approveCompany = asi.getApproveCompany();
        map.put("approveCompany", approveCompany);

        //승인대기 기업수
        int waitCompany = asi.getWatingCompany();
        map.put("waitCompany", waitCompany);

        //최근 7일자별 지원자수
        ArrayList<ApplicantsbyDateVO> list = asi.getApplicantsbyDate();
        map.put("ApplicantsbyDate", list);

        //전체합격자 중 남성
        int passerMale = asi.getPasserMale();
        map.put("passerMale", passerMale);
        System.out.println("남자합격자"+passerMale);

        //전체합격자 중 여성
        int passerFemale = asi.getPasserFemale();
        map.put("passerFemale", passerFemale);


        return map;
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
        //System.out.println(list.toString());

        return ogate;
    };

    @GetMapping("/21")
    public Map<String, Object> getStatistics(@RequestParam("sd") String sd,
                                             @RequestParam("ed") String ed,
                                             @RequestParam("day") String day){
                                             

        Map<String, Object> smap = new HashMap<>();
        
        System.out.println(sd);
        System.out.println(ed);

        //기간별 사이트 가입자수
        ArrayList<ApplicantsbyDateVO>  joinUser = asi.getJoinUser(ed, day);
        smap.put("joinUser", joinUser);

           //기간별 지원자수
        ArrayList<ApplicantsbyDateVO> applyUser = asi.getApplyUser(ed, day);
        smap.put("applyUser", applyUser);

        //기간별 합격자수
        ArrayList<ApplicantsbyDateVO> passUser = asi.getPassUser(ed, day);
        smap.put("passUser", passUser);

        return smap;
    }

}