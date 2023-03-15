package com.finalpj.backend.controller;

import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.service.CompanyService;

@RestController
public class JobPostingController {

    @Autowired
    private CompanyService service;

    @GetMapping("/jobPostingList")
    public List<JobPostingVO> getJobList() {
        return service.getJobList();
    }

    @PostMapping("/jobPostingRegist")
    public void regist(@RequestBody JobPostingVO vo) {
        System.out.println(vo.toString());
        service.regist(vo);
    }

    @GetMapping("/jobPostingDetail/{j_no}")
    public List<JobPostingVO> getJobDetail(@PathVariable(value = "j_no", required = false) int j_no) {
        List<JobPostingVO> list = service.getJobDetail(j_no);
        return list;
    }

    @PostMapping("/jobPostingUpdate")
    public void update(@RequestBody JobPostingVO vo) {
        System.out.println(vo.toString());
        service.update(vo);
    }

    @PostMapping("/jobPostingDelete")
    public void delete(@RequestBody JobPostingVO vo) {
        service.delete(vo.getJ_no());
    }
}
