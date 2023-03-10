package com.finalpj.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
	@Qualifier("TestService")
	private TestService testService;
    
    @PostMapping("/registForm")
	public String registForm(@RequestBody UserVO vo){

        System.out.println(vo.toString());
        //  result = testService.regist(vo);
//        testService.regist(vo);

      
        return "success";
    }
   
}
