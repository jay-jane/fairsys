package com.finalpj.backend.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.util.Criteria;

@Mapper
public interface AdminUserMapper {

        //테스트출력
        public ArrayList<UserVO> test();


        //리스트 출력
        public ArrayList<UserVO> getList(@Param("cri") Criteria cri);

        //페이지네이션용
        public int getTotal(@Param("cri") Criteria cri);
    


}
