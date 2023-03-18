package com.finalpj.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.command.UserStatusVO;
import com.finalpj.backend.util.ResumeCriteria;

@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    public ResumeMapper resumemapper;


    // @Override
    // public ArrayList<ResumeWriteVO> ApplyStatus() {
    //     return resumemapper.ApplyStatus();
    // }

    @Override
    public void ResumeRegist(ResumeWriteVO vo) {
        resumemapper.ResumeRegist(vo);
    }

    @Override
    public List<UserStatusVO> ResumeModify(int user_no) {
        return resumemapper.ResumeModify(user_no);
       
    }

    @Override
    public void ResumeUpdate(ResumeWriteVO vo) {
        resumemapper.ResumeUpdate(vo);
    }

    @Override
    public ArrayList<UserStatusVO> UserMyPage() {
        return resumemapper.UserMyPage();
    }

    @Override
    public void delete(int w_no) {
        resumemapper.delete(w_no);
    }


    @Override
    public ArrayList<UserStatusVO> getList(ResumeCriteria cri) {
        return resumemapper.getList(cri);
    }

    @Override
    public int getTotal(ResumeCriteria cri) {
        return resumemapper.getTotal(cri);
    }

    @Override
    public void updateStatus(UserStatusVO vo) {
        resumemapper.updateStatus(vo);
    }
}