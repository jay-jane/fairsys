package com.finalpj.backend.service;

import java.util.List;

import com.finalpj.backend.command.JobPostingVO;

public interface CompanyService {

    void regist(JobPostingVO vo);
    List<JobPostingVO> getJobDetail();
    void update(JobPostingVO vo);
}
