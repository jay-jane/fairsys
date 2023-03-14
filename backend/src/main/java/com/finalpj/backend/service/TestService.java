package com.finalpj.backend.service;

import com.finalpj.backend.command.UserVO;

public interface TestService {
    public int regist(UserVO vo);
    public int checkId(String user_id);
}
