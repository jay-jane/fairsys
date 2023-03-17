package com.finalpj.backend.service;

import java.util.ArrayList;

import com.finalpj.backend.command.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminCompanyService")
public class AdminCompanyServiceimpl implements AdminCompanyService {


	@Autowired
	private AdminCompanyMapper adminCompanyMapper ;

	@Override
	public ArrayList<CompanyVO> getList(String com_id) {
		
		return adminCompanyMapper.getList(com_id);

	}



}
