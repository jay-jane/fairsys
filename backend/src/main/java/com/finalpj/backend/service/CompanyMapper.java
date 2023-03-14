package com.finalpj.backend.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.finalpj.backend.command.JobPostingVO;

@Mapper
public interface CompanyMapper {
    void regist(JobPostingVO vo);
    List<JobPostingVO> getJobDetail();
    void update(JobPostingVO vo);
}
