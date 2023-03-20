package com.finalpj.backend.controller.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.command.UserStatusVO;
import com.finalpj.backend.service.CompanyService;
import com.finalpj.backend.util.JobCriteria;
import com.finalpj.backend.util.JobOneGate;
import com.finalpj.backend.util.JobPageVO;

@RestController
public class JobPostingController {

    @Autowired
    private CompanyService service;
    
    // @GetMapping("/jobPostingList")
    // public List<JobPostingVO> getJobList(JobCriteria jcri) {
    //     return service.getJobList(jcri);
    // }
    @GetMapping("/4/")
    public JobOneGate list(JobCriteria jcri) {
        //페이지네이션 처리
        int total =  service.getTotal(jcri);
        JobPageVO pageVO = new JobPageVO(jcri, total);
        //게시글 처리
        List<JobPostingVO> list = service.getJobList(jcri);
        JobOneGate ogate = new JobOneGate(list, pageVO);
        return ogate;
    }

    @GetMapping("/getTotal")
    public int getTotal(JobCriteria jcri) {
        return service.getTotal(jcri);
    }

    @PostMapping("/jobPostingRegist")
    public void regist(@RequestBody JobPostingVO vo) {
        service.regist(vo);
    }

    @GetMapping("/jobPostingDetail/{j_no}")
    public List<JobPostingVO> getJobDetail(@PathVariable(value = "j_no", required = false) int j_no) {
        List<JobPostingVO> list = service.getJobDetail(j_no);
        return list;
    }

    @PostMapping("/jobPostingUpdate")
    public void update(@RequestBody JobPostingVO vo) {
        service.update(vo);
    }

    @PostMapping("/jobPostingDelete")
    public void delete(@RequestBody JobPostingVO vo) {
        service.delete(vo.getJ_no());
    }

    @GetMapping("/apply")
    public ResumeWriteVO apply(HttpServletRequest request, HttpServletResponse response) {
        String user_id = request.getParameter("user_id");
        return service.apply(user_id);
    }
    @PostMapping("/applyInsert")
    public void applyInsert(@RequestBody UserStatusVO vo) {
        System.out.println(vo.toString());
        // service.applyInsert(vo);
    }

    @GetMapping("/getCompanyVO/{com_id}")
    public List<CompanyVO> getCompanyVO(HttpServletRequest request, HttpServletResponse response) {
        String com_id = request.getParameter("com_id");
        List<CompanyVO> list = service.getCompanyVO(com_id);
        return list;
    }

}
