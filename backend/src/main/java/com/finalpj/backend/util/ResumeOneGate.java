package com.finalpj.backend.util;

import java.util.ArrayList;

import com.finalpj.backend.command.ResumeWriteVO;

import lombok.Data;

@Data
public class ResumeOneGate {

    private ArrayList<ResumeWriteVO> list;
    private ResumePageVO pageVO;

    public ResumeOneGate() {
        super();
    }

    public ResumeOneGate(ArrayList<ResumeWriteVO> list, ResumePageVO pageVO){
        this.list = list;
        this.pageVO = pageVO;
    }


    
    
}
