package com.finalpj.backend.service;

import org.springframework.stereotype.Service;

import com.finalpj.backend.command.JobPostingVO;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyMapper mapper;

    @Override
    public void regist(JobPostingVO vo) {
        mapper.regist(vo);
    }
    
}
