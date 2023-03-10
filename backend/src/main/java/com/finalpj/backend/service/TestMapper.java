package com.finalpj.backend.service;

import org.apache.ibatis.annotations.Mapper;

import com.finalpj.backend.command.UserVO;

@Mapper
public interface TestMapper {
    public int regist(UserVO vo);
}
