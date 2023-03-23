package com.finalpj.backend.service;

import java.util.List;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.command.UserStatusVO;
import com.finalpj.backend.util.JobCriteria;

public interface CompanyService {

    void regist(JobPostingVO vo);
    List<JobPostingVO> getJobDetail(int j_no);
    void update(JobPostingVO vo);
    void delete(int j_no);
    List<JobPostingVO> getJobList(JobCriteria jcri);
    int getTotal(JobCriteria jcri);
    List<CompanyVO> getCompanyVO(String com_id);
    ResumeWriteVO apply(String user_id);
    void applyInsert(UserStatusVO vo);
    int checkApply(String user_id, String com_id);
    int checkPosting(String com_id);
    String getJno(String com_id);
}
