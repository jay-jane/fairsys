package com.finalpj.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.command.UserStatusVO;
import com.finalpj.backend.util.JobCriteria;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper mapper;

    @Override
    public void regist(JobPostingVO vo) {
        mapper.regist(vo);
    }

    @Override
    public List<JobPostingVO> getJobDetail(int j_no) {
        return mapper.getJobDetail(j_no);
    }

    @Override
    public void update(JobPostingVO vo) {
        mapper.update(vo);
    }

    @Override
    public void delete(int j_no) {
        mapper.delete(j_no);
    }

    @Override
    public List<JobPostingVO> getJobList(JobCriteria jcri) {
        return mapper.getJobList(jcri);
    }

    @Override
    public int getTotal(JobCriteria jcri) {
        return mapper.getTotal(jcri);
    }

    @Override
    public List<CompanyVO> getCompanyVO(String com_id) {
        return mapper.getCompanyVO(com_id);
    }

    @Override
    public ResumeWriteVO apply(String user_id) {
        return mapper.apply(user_id);
    }

    @Override
    public void applyInsert(UserStatusVO vo) {
        System.out.println(vo.toString());
        mapper.applyInsert(vo);
    }

    @Override
    public int checkApply(String user_id, String com_id) {
        return mapper.checkApply(user_id, com_id);
    }

    @Override
    public int checkPosting(String com_id) {
        return mapper.checkPosting(com_id);
    }

    @Override
    public String getJno(String com_id) {
        return mapper.getJno(com_id);
    }
    
}
