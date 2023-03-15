package com.finalpj.backend.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.finalpj.backend.command.JobPostingVO;

@Mapper
public interface CompanyMapper {
    void regist(JobPostingVO vo);
    List<JobPostingVO> getJobDetail(int j_no);
    void update(JobPostingVO vo);
    void delete(int j_no);
    List<JobPostingVO> getJobList();
}
