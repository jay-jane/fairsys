package com.finalpj.backend.service;

import java.util.ArrayList;
import java.util.List;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.util.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminCompanyService")
public class AdminCompanyServiceimpl implements AdminCompanyService {

  @Autowired
  AdminCompanyMapper adminCompanyMapper;

  @Override
  public ArrayList<CompanyVO> getList(Criteria cri) {
    return adminCompanyMapper.getList(cri);

  }

  @Override
  public ArrayList<CompanyVO> getNlist(Criteria cri) {
    return adminCompanyMapper.getNlist(cri);

  }

  @Override
  public void companyModify(String com_id) {
    adminCompanyMapper.companyModify(com_id);

  }

  @Override
  public void companyDelete(String com_id) {
    adminCompanyMapper.companyDelete(com_id);
  }

  @Override
  public int getTotal1(Criteria cri) {
    return adminCompanyMapper.getTotal1(cri);

  }

  @Override
  public int getTotal2(Criteria cri) {
    return adminCompanyMapper.getTotal2(cri);

  }

  @Override
  public ArrayList<CompanyVO> Companydetail(String com_id) {
    return adminCompanyMapper.Companydetail(com_id);
  }
}
