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

@RestController
public class ResumeController {
 
    @Autowired
    private ResumeService resumeService;

    //이력서 리스트
    @GetMapping("/ApplyStatus")
    public ArrayList<ResumeWriteVO> ApplyStatus (){

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
        //System.out.println(vo.toString());
        resumeService.ResumeUpdate(vo);    
    }
}