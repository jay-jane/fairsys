package com.finalpj.backend.controller.user;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.service.CompanyService;
import com.finalpj.backend.service.TestService;
import com.finalpj.backend.util.JobCriteria;
import com.finalpj.backend.util.JobOneGate;
import com.finalpj.backend.util.JobPageVO;
import com.finalpj.backend.util.JwtUtil;

@RestController
@RequestMapping("")
public class TestController2 {

	@Autowired
	@Qualifier("TestService")
	private TestService testService;



	@Autowired
	private JwtUtil jwtUtil;


	@GetMapping("/main2/")
	public JobOneGate list(JobCriteria jcri) {
	
		System.out.println(jcri.toString());
		
		//페이지네이션 처리
		int total =  testService.getTotal();
		JobPageVO pageVO = new JobPageVO(jcri, total);
		//게시글 처리
		List<JobPostingVO> list = testService.getList(jcri);
		System.out.println(list.size());
		JobOneGate ogate = new JobOneGate(list, pageVO);
		System.out.println("아임 리스트:"+ list.toString());
		return ogate;
	}


	//메인페이지
	@GetMapping("/main2")
	public List<JobPostingVO> main2() {
		List<JobPostingVO> list = testService.main2();
		System.out.println(list.toString());
		return list;
	}

	//개인 회원가입 폼
	@PostMapping("/3-1/registForm")
	public String registForm(@RequestBody UserVO vo){

		System.out.println(vo.toString());
		testService.regist(vo);
		//   testService.regist(vo);


		return "success";
	}

	//개인 회원 아이디 중복 체크
	@PostMapping("/3-1/checkId")
	public boolean checkId(@RequestBody UserVO vo){


		System.out.println(vo.getUser_id());
		String user_id = vo.getUser_id();
		testService.checkId(user_id);

		if(testService.checkId(user_id)>=1) {
			return false;
		}
		return true;
	}


	//개인 로그인
	@PostMapping("/3-1/loginForm")
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

			return new ResponseEntity( resultMap, header, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity (HttpStatus.UNAUTHORIZED);
	}

	//	//카카오 로그인
	//	@GetMapping("/api/login")
	//	public String kakaoLogin() {
	//		String url = "https://kauth.kakao.com/oauth/authorize?client_id=fbe370a3129ac98f0f32d18a329462b9&redirect_uri=http://localhost:8081/kakaoLogin&response_type=code";
	//		System.out.println("login 컨트롤러 접근");
	//		return url;
	//	}
	//	
	//마이페이지
	@GetMapping("/6/mypage")
	public UserVO mypage(HttpServletRequest request, HttpServletResponse response){

		String user_id = request.getParameter("user_id");
		UserVO vo = testService.getUserInfo(user_id);
		return vo;
	}

	//회원정보수정페이지
	@GetMapping("/9")
	public UserVO getuserInfo(HttpServletRequest request, HttpServletResponse response){

		String user_id = request.getParameter("user_id");
		UserVO vo = testService.getUserInfo(user_id);

		return vo;
	}

	//회원정보수정
	@PostMapping("/9/modifyForm")
	public String modifyForm(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVO vo){

		System.out.println(vo.toString());
		String user_id = request.getParameter("user_id");
		System.out.println(user_id);
		vo.setUser_id(user_id); 
		testService.modifyForm(vo);
		return "success";
	}







	//-------------------------------------------------------------------------------------------------------------//

	//기업 회원가입 폼
	@PostMapping("/3-2/registForm")
	public String registForm2(@RequestBody CompanyVO vo){

		System.out.println(vo.toString());
		testService.regist2(vo);
		//   testService.regist(vo);


		return "success";
	}



	//기업 회원 아이디 중복 체크
	@PostMapping("/3-2/checkId")
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

	//기업 로그인
	@PostMapping("/3-2/loginForm")
	public ResponseEntity login(@RequestBody CompanyVO vo, HttpServletResponse res, HttpServletRequest req){


		System.out.println(vo.toString());


		CompanyVO companyVO  = testService.login2(vo);
		//		if(companyVO!=null) {
		//			System.out.println(companyVO.toString());
		//
		//		}
		String com_status=companyVO.getCom_status();
		System.out.println(com_status);
		//어드민으로부터 승인이 나지 않았을 경우 로그인 불가
		if(com_status.equals("N")) {
			return new ResponseEntity (HttpStatus.FORBIDDEN);
		}

		if(companyVO!=null) {
			Map<String, Object> resultMap = new HashMap<>();

			String com_id = companyVO.getCom_id();
			String ut_no = companyVO.getUt_no();
			String authToken = jwtUtil.createAuthToken(com_id);

			//resultMap.put("jwt-auth-token", authToken);
			resultMap.put("com_id", com_id);
			resultMap.put("ut_no", ut_no);

			HttpHeaders header = new HttpHeaders();
			header.add("Authorization", "Bearer " + authToken);

			//Map<String, Object> info = jwtUtil.checkAndGetClaims(authToken);
			//resultMap.putAll(info);

			return new ResponseEntity( resultMap, header, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity (HttpStatus.UNAUTHORIZED);
	}
}
