package com.finalpj.backend.controller;
import java.util.ArrayList;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.service.AdminCompanyService;


import org.springframework.beans.factory.annotation.Autowired;


@RestController

public class AdminCompanyController {
    
         
        @Autowired
        private AdminCompanyService admincompanyService;
    

        @GetMapping("/18")
        public  ArrayList<CompanyVO> list (){

    
            ArrayList<CompanyVO> list = admincompanyService.getList();
            System.out.println(list.toString());    
            return list;
        }

         @GetMapping("/19/1")
         public  ArrayList<CompanyVO> Nlist (){
    
            ArrayList<CompanyVO> list = admincompanyService.getNlist();
            System.out.println(list.toString());    
            return list;
         }    

         @PostMapping("/19/2")
         public void companyModify(@RequestBody CompanyVO vo){
            admincompanyService.companyModify(vo.getCom_id());
         }

    }

