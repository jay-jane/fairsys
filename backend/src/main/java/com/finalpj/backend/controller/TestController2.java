package com.finalpj.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.service.TestService;

@RestController
@RequestMapping("/33")
public class TestController2 {

    @Autowired
	@Qualifier("TestService")
	private TestService testService;
    
    //회원가입 폼
    @PostMapping("/registForm")
	public String registForm(@RequestBody UserVO vo){

        System.out.println(vo.toString());
        testService.regist(vo);
//   testService.regist(vo);

      
        return "success";
    }
    
    //아이디 중복 체크
    @PostMapping("/checkId")
	public boolean checkId(@RequestBody UserVO vo){

        
        System.out.println(vo.getUser_id());
        String user_id = vo.getUser_id();
        testService.checkId(user_id);
      
       if(testService.checkId(user_id)>=1) {
        	return false;
        }
        return true;
    }

   
}
