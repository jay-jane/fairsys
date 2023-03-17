package com.finalpj.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.service.ResumeService;
import com.finalpj.backend.util.ResumeCriteria;
import com.finalpj.backend.util.ResumeOneGate;
import com.finalpj.backend.util.ResumePageVO;

@RestController
public class ResumeController {
 
    @Autowired
    private ResumeService resumeService;

    @GetMapping("/ApplyStatus")
    public ResumeOneGate list(ResumeCriteria cri) {
                //페이지네이션 처리
                int total =  resumeService.getTotal(cri);
                ResumePageVO pageVO = new ResumePageVO(cri, total);
                //게시글 처리
                ArrayList<ResumeWriteVO> list = resumeService.getList(cri);
                ResumeOneGate ogate = new ResumeOneGate(list, pageVO);
                // System.out.println(list.toString());
                return ogate;
    }
    
    //    //이력서 리스트
    //    @GetMapping("/ApplyStatus")
    //    public ArrayList<ResumeWriteVO> ApplyStatus (){


    //        ArrayList<ResumeWriteVO> ApplyStatus = resumeService.ApplyStatus();
    //        System.out.println(ApplyStatus.toString());
    //        resumeService.ApplyStatus();
    //        return ApplyStatus;
    //    }
   
       //이력서 작성
       @PostMapping("/ResumeRegist")
       public void ResumeRegist(@RequestBody ResumeWriteVO vo){
   
           System.out.println(vo.toString());
           resumeService.ResumeRegist(vo);
       }
   
       //이력서 상세조회
       @GetMapping("/ResumeModify/{w_no}")
       public List<ResumeWriteVO> ResumeModify(@PathVariable(value = "w_no") int w_no)  {
           List<ResumeWriteVO> list = resumeService.ResumeModify(w_no);
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