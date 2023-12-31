package com.finalpj.backend.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.command.UserStatusVO;
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
    ResumeWriteVO apply(String user_id);
    void applyInsert(UserStatusVO vo);
    int checkApply(@Param("user_id") String user_id, @Param("com_id") String com_id);
    int checkPosting(@Param("com_id") String com_id);
    String getJno(String com_id);
    void uploadImg(@Param("j_img_uuid") String j_img_uuid, @Param("j_img_fileName") String j_img_fileName, @Param("com_id") String com_id);
}
