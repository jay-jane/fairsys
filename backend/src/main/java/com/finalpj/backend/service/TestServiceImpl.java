package com.finalpj.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.UserVO;

@Service("TestService")
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper mapper;

	@Override
	public int regist(UserVO vo){
		return mapper.regist(vo);

	}
	@Override
	public int checkId(String user_id){
		System.out.println(mapper.checkId(user_id));
		return mapper.checkId(user_id);

	}
	
	
	@Override
	public UserVO login(UserVO vo) {
		return mapper.login(vo);
	}
	
	
	
	
	@Override
	public int regist2(CompanyVO vo) {
		return mapper.regist2(vo);


	}
	@Override
	public int checkId2(String com_id) {
		System.out.println(mapper.checkId2(com_id));
		return mapper.checkId2(com_id);

	}
	
}
