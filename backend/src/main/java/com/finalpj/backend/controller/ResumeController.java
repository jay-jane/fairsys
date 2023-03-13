package com.finalpj.backend.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.ResumeVO;
import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.service.ResumeService;

@RestController
@RequestMapping("/resume")
public class ResumeController {
 
    @Autowired
    private ResumeService resumeService;


    @GetMapping("/10")
    public ArrayList<ResumeVO> list (){

        ArrayList<ResumeVO> list =resumeService.getList();
        System.out.println(list.toString());

        return list;
    }

    @PostMapping("/26")
	public String registForm(@RequestBody ResumeWriteVO vo){

        System.out.println(vo.toString());

      
        return "/26";
    }

}