package com.finalpj.backend.service;

import org.apache.ibatis.annotations.Mapper;

import com.finalpj.backend.command.JobPostingVO;

@Mapper
public interface CompanyMapper {
    void regist(JobPostingVO vo);
}
