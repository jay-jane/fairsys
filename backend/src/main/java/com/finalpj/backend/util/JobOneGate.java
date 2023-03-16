package com.finalpj.backend.util;

import java.util.List;

import com.finalpj.backend.command.JobPostingVO;

import lombok.Data;

@Data
public class JobOneGate {

    private List<JobPostingVO> jobList;
    private JobPageVO pageVO;

    public JobOneGate() {
        super();
    }

    public JobOneGate(List<JobPostingVO> jobList, JobPageVO pageVO){
        this.jobList = jobList;
        this.pageVO = pageVO;
    }
}
