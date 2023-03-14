package com.finalpj.backend.service;

import java.util.ArrayList;

import com.finalpj.backend.command.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminCompanyServiceimpl implements adminCompanyService {

    
    @Autowired
    private adminCompanyMapper companyMapper ;

    @Override
	public ArrayList<CompanyVO> getList(String com_id) {
		return companyMapper.getList(com_id);
    
    }
    


}
