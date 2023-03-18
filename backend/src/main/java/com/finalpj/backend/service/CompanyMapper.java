package com.finalpj.backend.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.util.JobCriteria;

@Mapper
public interface CompanyMapper {
    void regist(JobPostingVO vo);
    List<JobPostingVO> getJobDetail(int j_no);
    void update(JobPostingVO vo);
    void delete(int j_no);
    List<JobPostingVO> getJobList(@Param("jcri") JobCriteria jcri);
    int getTotal(@Param("jcri") JobCriteria jcri);
    List<CompanyVO> getCompanyVO(@Param("com_id") String com_id);
}
