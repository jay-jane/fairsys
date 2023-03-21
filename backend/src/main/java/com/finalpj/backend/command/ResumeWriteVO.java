package com.finalpj.backend.command;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeWriteVO {
    private int user_no;
    private String user_name;
    private String user_phone;
    private String user_email;
    private String user_address;
    private String user_gender;
    private String user_level;
    private String user_finish;
    private String user_major;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date user_fndate;
    private String user_com;
    private String user_position;
    private Date user_join;
    private Date user_leave;
    private String user_subject;
    private String user_score;
    private Date user_get; 
    private String user_license;
    private Date user_getlicense;
    private String user_id;
    private String com_id;
}
