package com.finalpj.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.JobCriteria;

@Service("UserService")
public class UserServiceImpl implements UserService {


	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<JobPostingVO> main2() {
		return userMapper.main2();
	}
	
	@Override
	public int getTotal() {
		return userMapper.getTotal();
	}
	
	@Override
	public List<JobPostingVO> getList(JobCriteria jcri) {
        return userMapper.getList(jcri);
	}

	
	//----------------------------------------------/
	
	
	//개인 회원 가입 
	@Override
	public int regist(UserVO vo){
		return userMapper.regist(vo);

	}
	
    // 개인 회원 아이디 중복 체크
	@Override
	public int checkId(String user_id){
		System.out.println(userMapper.checkId(user_id));
		return userMapper.checkId(user_id);

	}
	
    // 개인 회원 로그인
	@Override
	public UserVO login(UserVO vo) {
		return userMapper.login(vo);
	}
	
    //회원정보 가져오기
	@Override
	public UserVO getUserInfo(String user_id) {
		
		return userMapper.getUserInfo(user_id);
	}
	
    //회원 정보 수정하기
	@Override
	public void modifyForm(UserVO vo) {
		userMapper.modifyForm(vo);
	}
	
	//회원 탈퇴
	@Override
	public void deleteForm(String user_id) {
		userMapper.deleteForm(user_id);
		
	}

	//===========================================================================================//
    // 기업 회원 가입
	@Override
	public int regist2(CompanyVO vo) {
		return userMapper.regist2(vo);


	}
	
    // 기업 회원 아이디 중복 체크
	@Override
	public int checkId2(String com_id) {
		System.out.println(userMapper.checkId2(com_id));
		return userMapper.checkId2(com_id);

	}
	
	// 기업 회원 로그인
	@Override
	public CompanyVO login2(CompanyVO vo) {
		
		return userMapper.login2(vo);
	}
	
	@Override
	public CompanyVO getComInfo(String com_id) {
		return userMapper.getComInfo(com_id);
	}

	@Override
	public void modifyForm2(CompanyVO vo) {
		userMapper.modifyForm2(vo);
		
	}
	
	//기업 회원 탈퇴
	@Override
	public void deleteForm2(String com_id) {
		System.out.println("매퍼쪽으로 넘어오는가?");
		userMapper.deleteForm2(com_id);
		
	}






	


	
}
