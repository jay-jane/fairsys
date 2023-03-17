package com.finalpj.backend.service;
import org.apache.ibatis.annotations.Mapper;
import com.finalpj.backend.command.CompanyVO;

import java.util.ArrayList;

@Mapper 
public interface AdminCompanyMapper {

	
public ArrayList<CompanyVO> getList();

public ArrayList<CompanyVO> getNlist();


 public void companyModify(String com_id);

 public void companyDelete(String com_id);
}