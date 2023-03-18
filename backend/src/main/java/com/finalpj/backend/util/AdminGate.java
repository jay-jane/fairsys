package com.finalpj.backend.util;


import java.util.ArrayList;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.EmploymentQnaVO;

import lombok.Data;

@Data
public class AdminGate {
    


    private ArrayList<CompanyVO> list;
    private PageVO pageVO;

  public AdminGate(){
    super();
  }   

  public AdminGate(ArrayList<CompanyVO> list, PageVO pageVO){
    this.list = list;
    this.pageVO = pageVO;
}
}
