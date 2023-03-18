package com.finalpj.backend.service;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.util.Criteria;

import java.util.ArrayList;

public interface AdminCompanyService {

    public ArrayList<CompanyVO> getList(Criteria cri);

    public ArrayList<CompanyVO> getNlist(Criteria cri);

    public void companyModify(String com_id);

    public void companyDelete(String com_id);

    public int getTotal(Criteria cri);
}