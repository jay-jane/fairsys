package com.finalpj.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.service.ResumeService;
import com.finalpj.backend.util.Criteria;
import com.finalpj.backend.util.PageVO;

@RestController
public class ResumeController {
 
    @Autowired
    private ResumeService resumeService;

       //이력서 리스트
       @GetMapping("/ApplyStatus")
       public ArrayList<ResumeWriteVO> ApplyStatus (Criteria cri){

        //페이지네이션 처리
        int total = resumeService.getTotal(cri);
        PageVO pageVO = new PageVO(cri, total);


   
           ArrayList<ResumeWriteVO> ApplyStatus = resumeService.ApplyStatus();
           System.out.println(ApplyStatus.toString());
           resumeService.ApplyStatus();
           return ApplyStatus;
       }
   
       //이력서 작성
       @PostMapping("/ResumeRegist")
       public String ResumeRegist(@RequestBody ResumeWriteVO vo){
   
           System.out.println(vo.toString());
           resumeService.ResumeRegist(vo);
         
           return "ResumeModify";
       }
   
       //이력서 상세조회
       @GetMapping("/ResumeModify")
       public List<ResumeWriteVO> ResumeModify() {
           List<ResumeWriteVO> list = resumeService.ResumeModify();
           System.out.println(list.toString());
          
           return list;
       }
   
       //이력서 수정
      
       @PostMapping("/ResumeUpdate")
       public void ResumeUpdate(@RequestBody ResumeWriteVO vo) {
        //    System.out.println(vo.toString());
           resumeService.ResumeUpdate(vo);    
       }
    


        //이력서 마이페이지
        @GetMapping("/UserMyPage")
        public ArrayList<ResumeWriteVO> UserMyPage (){
    
            ArrayList<ResumeWriteVO> UserMyPage = resumeService.UserMyPage();
            System.out.println(UserMyPage.toString());
            resumeService.UserMyPage();
            return UserMyPage;
        }

        //삭제
        @PostMapping("/ResumeDelete")
        public void delete(@RequestBody ResumeWriteVO vo) {
            System.out.println(vo.getW_no());
            resumeService.delete(vo.getW_no());
        
        
}

}