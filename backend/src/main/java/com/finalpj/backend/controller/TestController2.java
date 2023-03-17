package com.finalpj.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.service.TestService;
import com.finalpj.backend.util.JwtUtil;

@RestController
@RequestMapping("")
public class TestController2 {

	@Autowired
	@Qualifier("TestService")
	private TestService testService;

	@Autowired
	private JwtUtil jwtUtil;
	
	//개인 회원가입 폼
	@PostMapping("/33/registForm")
	public String registForm(@RequestBody UserVO vo){

		System.out.println(vo.toString());
		testService.regist(vo);
		//   testService.regist(vo);


		return "success";
	}

	//개인 회원 아이디 중복 체크
	@PostMapping("/33/checkId")
	public boolean checkId(@RequestBody UserVO vo){


		System.out.println(vo.getUser_id());
		String user_id = vo.getUser_id();
		testService.checkId(user_id);

		if(testService.checkId(user_id)>=1) {
			return false;
		}
		return true;
	}

//	//마이페이지
//	@PostMapping("/6/mypage")
//	public ResponseEntity mypage(@RequestBody UserVO vo, HttpServletResponse res,HttpServletRequest req){
//		
//		HttpHeaders header = new HttpHeaders();
//		
//		return ResponseEntity;
//	}
	//개인 로그인
	@PostMapping("/33/loginForm")
	public ResponseEntity login(@RequestBody UserVO vo, HttpServletResponse res,HttpServletRequest req){

		
		System.out.println(vo.toString());
	

		UserVO userVO  =testService.login(vo);
		if(userVO!=null) {
			System.out.println(userVO.toString());
			
		}
		
		if(userVO!=null) {
			Map<String, Object> resultMap = new HashMap<>();
			String user_id = userVO.getUser_id();
			String ut_no = userVO.getUt_no();
			String authToken = jwtUtil.createAuthToken(user_id);

			//resultMap.put("jwt-auth-token", authToken);
			resultMap.put("user_id", user_id);
			resultMap.put("ut_no", ut_no);

			HttpHeaders header = new HttpHeaders();
			header.add("Authorization", "Bearer " + authToken);

			//Map<String, Object> info = jwtUtil.checkAndGetClaims(authToken);
			//resultMap.putAll(info);
			
			return new ResponseEntity( resultMap,header, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity (HttpStatus.UNAUTHORIZED);
	}

	//기업 회원가입 폼
	@PostMapping("/3/registForm")
	public String registForm2(@RequestBody CompanyVO vo){

		System.out.println(vo.toString());
		testService.regist2(vo);
		//   testService.regist(vo);


		return "success";
	}



	//기업 회원 아이디 중복 체크
	@PostMapping("/3/checkId")
	public boolean checkId2(@RequestBody CompanyVO vo){


		System.out.println(vo.getCom_id());
		String com_id = vo.getCom_id();
		//    	testService.checkId2(com_id);
		//    	
		if(testService.checkId2(com_id)>=1) {
			return false;
		}
		return true;
	}
	


}
