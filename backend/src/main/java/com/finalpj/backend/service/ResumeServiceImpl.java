package com.finalpj.backend.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpj.backend.command.ResumeVO;
import com.finalpj.backend.command.ResumeWriteVO;

@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    public ResumeMapper resumemapper;


    @Override
    public ArrayList<ResumeVO> getList() {
        return resumemapper.getList();


    }
    @Override
    public int regist(ResumeWriteVO vo) {
        return resumemapper.regist(vo);
    }
}