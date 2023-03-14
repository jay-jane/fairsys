package com.finalpj.backend.controller;
import java.util.ArrayList;



import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.service.AdminCompanyService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@RestController
@RequestMapping("/18")
public class AdminCompanyController {
    
         
        @Autowired
        @Qualifier("adminCompanyService")
        private AdminCompanyService admincompanyService;
    
        @GetMapping("/")
        public  ArrayList<CompanyVO> list (String com_id){
    
            ArrayList<CompanyVO> list = admincompanyService.getList(com_id);
            System.out.println(list.toString());    
            return list;
        }
    }


