package com.finalpj.backend.service;

import java.util.ArrayList;

import com.finalpj.backend.command.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminCompanyService")
public class AdminCompanyServiceimpl implements AdminCompanyService {



    @Override
	public ArrayList<CompanyVO> getList() {
		return adminCompanyMapper.getList();
    
    }
    
  @Override
	public ArrayList<CompanyVO> getNlist() {
	return adminCompanyMapper.getNlist();
  }


   @Override
   public int companyModify(String com_id) {
     return adminCompanyMapper.companyModify(com_id);
    
  }
}


  

