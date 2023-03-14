package com.finalpj.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    public List<JobPostingVO> getJobDetail() {
        return mapper.getJobDetail();
    }

    @Override
    public void update(JobPostingVO vo) {
        mapper.update(vo);
    }
    
}
