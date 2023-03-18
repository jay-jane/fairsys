package com.finalpj.backend.util;

import java.util.ArrayList;

import com.finalpj.backend.command.UserStatusVO;

import lombok.Data;

@Data
public class ResumeOneGate {

    private ArrayList<UserStatusVO> list;
    private ResumePageVO pageVO;

    public ResumeOneGate() {
        super();
    }

    public ResumeOneGate(ArrayList<UserStatusVO> list, ResumePageVO pageVO){
        this.list = list;
        this.pageVO = pageVO;
    }


    
    
}
