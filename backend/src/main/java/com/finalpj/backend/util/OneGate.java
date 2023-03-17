package com.finalpj.backend.util;

import java.util.ArrayList;

import com.finalpj.backend.command.EmploymentQnaVO;

import lombok.Data;

@Data
public class OneGate {

    private ArrayList<EmploymentQnaVO> list;
    private PageVO pageVO;

    public OneGate() {
        super();
    }

    public OneGate(ArrayList<EmploymentQnaVO> list, PageVO pageVO){
        this.list = list;
        this.pageVO = pageVO;
    }


    
    
}
