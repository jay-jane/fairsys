package com.finalpj.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.service.CompanyService;

@RestController
public class JyTestController {
    
    private CompanyService service;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/getCategoryChild")
    public String getCategoryChild() {
        return "asdf";
    }

    @PostMapping("regist")
    public String regist(@RequestBody JobPostingVO vo) {
        System.out.println(vo.toString());
        service.regist(vo);
        return "submit";
    }

}
