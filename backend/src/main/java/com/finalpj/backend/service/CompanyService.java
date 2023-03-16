package com.finalpj.backend.service;

import java.util.List;

import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.util.JobCriteria;

public interface CompanyService {

    void regist(JobPostingVO vo);
    List<JobPostingVO> getJobDetail(int j_no);
    void update(JobPostingVO vo);
    void delete(int j_no);
    List<JobPostingVO> getJobList(JobCriteria jcri);
    int getTotal(JobCriteria jcri);
}
