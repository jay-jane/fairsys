package com.finalpj.backend.service;
import com.finalpj.backend.command.CompanyVO;
import java.util.ArrayList;

public interface AdminCompanyService{



public ArrayList<CompanyVO> getList();

public ArrayList<CompanyVO> getNlist();

public int companyModify(String com_id);


}