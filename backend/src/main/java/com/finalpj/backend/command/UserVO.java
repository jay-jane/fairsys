package com.finalpj.backend.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_birth;
    private String user_email;
    private String user_phone;
    private String user_gender;
    private String user_postcode;
    private String user_address;
    private String user_detail_address;
    private String ut_no;
    private String u_no;
    
}
