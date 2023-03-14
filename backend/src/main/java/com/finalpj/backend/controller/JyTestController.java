package com.finalpj.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.service.CompanyService;

@RestController
public class JyTestController {
    
    @Autowired
    private CompanyService service;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/getCategoryChild")
    public String getCategoryChild() {
        return "asdf";
    }

    @PostMapping("/regist")
    public void regist(@RequestBody JobPostingVO vo) {
        System.out.println(vo.toString());
        service.regist(vo);
    }
    
    @GetMapping("/getJobDetail")
    public List<JobPostingVO> getJobDetail() {
        List<JobPostingVO> list = service.getJobDetail();
        System.out.println(list.toString());
        return list;
    }
    
    @PostMapping("/update")
    public void update(@RequestBody JobPostingVO vo) {
        System.out.println(vo.toString());
        service.update(vo);    
    }
}
