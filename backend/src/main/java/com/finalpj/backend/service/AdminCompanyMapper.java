package com.finalpj.backend.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.util.Criteria;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface AdminCompanyMapper {

    public ArrayList<CompanyVO> getList(@Param("cri") Criteria cri);

    public ArrayList<CompanyVO> getNlist(@Param("cri") Criteria cri);

    public void companyModify(String com_id);

    public void companyDelete(String com_id);

    public ArrayList<CompanyVO> Companydetail(String com_id);

    public int getTotal1(@Param("cri") Criteria cri);

    public int getTotal2(@Param("cri") Criteria cri);
}