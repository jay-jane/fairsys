package com.finalpj.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpj.backend.command.JobPostingVO;

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
    public List<JobPostingVO> getJobList() {
        return mapper.getJobList();
    }
    
}
