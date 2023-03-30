package com.finalpj.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.service.UserService;

@Controller
public class HomeController {
	
    @GetMapping("/")
    public String main(){
        return "index";
    }

}  
