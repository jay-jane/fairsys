package com.finalpj.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.util.Criteria;

@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    public ResumeMapper resumemapper;


    @Override
    public ArrayList<ResumeWriteVO> ApplyStatus() {
        return resumemapper.ApplyStatus();
    }

    @Override
    public int ResumeRegist(ResumeWriteVO vo) {
        return resumemapper.ResumeRegist(vo);
    }

    @Override
    public List<ResumeWriteVO> ResumeModify() {
        return resumemapper.ResumeModify();
       
    }

    @Override
    public void ResumeUpdate(ResumeWriteVO vo) {
        resumemapper.ResumeUpdate(vo);
    }

    @Override
    public ArrayList<ResumeWriteVO> UserMyPage() {
        return resumemapper.UserMyPage();
    }

    @Override
    public void delete(int w_no) {
        resumemapper.delete(w_no);
    }
    public int getTotal(Criteria cri){
        return resumemapper.getTotal(cri);
    }

}