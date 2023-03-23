package com.finalpj.backend.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.JobCriteria;

@Mapper
public interface TestMapper {

	public List<JobPostingVO> main2();
    int getTotal();
    List<JobPostingVO> getList(@Param("jcri") JobCriteria jcri);

	//-------------------------------------------//

	//개인 회원 가입 
	public int regist(UserVO vo);
	// 개인 회원 아이디 중복 체크
	public int checkId(String user_id);
	// 개인 회원 로그인
	public UserVO login(UserVO vo);
	//회원정보 가져오기
	public UserVO getUserInfo(String user_id);
	//회원 정보 수정하기
	public void modifyForm(UserVO vo);

	//----------------------------------------------------------------//
	// 기업 회원 가입
	public int regist2(CompanyVO vo);
	// 기업 회원 아이디 중복 체크
	public int checkId2(String com_id);
	// 기업 회원 로그인
	public CompanyVO login2(CompanyVO vo);
}
