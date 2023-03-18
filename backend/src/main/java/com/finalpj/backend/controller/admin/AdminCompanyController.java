package com.finalpj.backend.controller.admin;

import java.io.Console;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.service.AdminCompanyService;
import com.finalpj.backend.util.AdminGate;
import com.finalpj.backend.util.Criteria;
import com.finalpj.backend.util.PageVO;

import org.springframework.beans.factory.annotation.Autowired;

@RestController

public class AdminCompanyController {

   @Autowired
   private AdminCompanyService admincompanyService;

   @GetMapping("/18/")
   public AdminGate list(Criteria cri) {

      int total = admincompanyService.getTotal(cri);
      PageVO pageVO = new PageVO(cri, total);

      ArrayList<CompanyVO> list = admincompanyService.getList(cri);
      AdminGate adminGate = new AdminGate(list, pageVO);

      System.out.println(list.toString());
      return adminGate;
   }

   @GetMapping("/19/1/")
   public AdminGate Nlist(Criteria cri) {

      int total = admincompanyService.getTotal(cri);
      PageVO pageVO = new PageVO(cri, total);

      ArrayList<CompanyVO> list = admincompanyService.getNlist(cri);
      System.out.println("ㅇㅇㅇ");
      AdminGate adminGate = new AdminGate(list, pageVO);

      System.out.println(list.toString());
      return adminGate;
   }

   @PostMapping("/19/2")
   public void companyModify(@RequestBody CompanyVO vo) {
      admincompanyService.companyModify(vo.getCom_id());
   }

   @PostMapping("/19/3")
   public void companyDelete(@RequestBody CompanyVO vo) {
      System.out.println("ㅇㅇㅇ");
      admincompanyService.companyDelete(vo.getCom_id());
   }

}
