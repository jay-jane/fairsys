package com.finalpj.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.command.UserStatusVO;
import com.finalpj.backend.command.UserVO;
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
    public List<ResumeWriteVO> ResumeModify(int user_no) {
        return resumemapper.ResumeModify(user_no);
       
    }

    @Override
    public void ResumeUpdate(ResumeWriteVO vo) {
        resumemapper.ResumeUpdate(vo);
    }

    @Override
    public ArrayList<ResumeWriteVO> UserMyPage(String user_id) {
        return resumemapper.UserMyPage(user_id);
    }

    @Override
    public void delete(int user_no) {
        resumemapper.delete(user_no);
    }


    @Override
    public ArrayList<UserStatusVO> getList(ResumeCriteria cri, String com_id) {
        return resumemapper.getList(cri, com_id);
    }

    @Override
    public int getTotal(ResumeCriteria cri, String com_id) {
        return resumemapper.getTotal(cri, com_id);
    }

    @Override
    public void updateStatus(UserStatusVO vo) {
        resumemapper.updateStatus(vo);
    }

    @Override
    public List<UserStatusVO> ResumeComModify(int user_no) {
        return resumemapper.ResumeComModify(user_no);
    }

    @Override
    public List<UserVO> getUserVO(String user_id) {
        return resumemapper.getUserVO(user_id);
    }

    @Override
    public List<UserStatusVO> UserStatus(String user_id) {
        return resumemapper.UserStatus(user_id);
    
    }
}