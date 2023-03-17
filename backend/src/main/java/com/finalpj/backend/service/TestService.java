package com.finalpj.backend.service;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.UserVO;

public interface TestService {
	//개인 회원 가입 
    public int regist(UserVO vo);
    // 개인 회원 아이디 중복 체크
    public int checkId(String user_id);
    // 개인 회원 로그인
    public UserVO login(UserVO vo);
    
    
    // 기업 회원 가입
    public int regist2(CompanyVO vo);
    // 기업 회원 아이디 중복 체크
    public int checkId2(String com_id);
}
