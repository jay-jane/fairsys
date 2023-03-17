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
    private int w_no;
    private String w_name;
    private String w_hp;
    private String w_email;
    private String w_address;
    private String w_gender;
    private String w_level;
    private String w_finish;
    private String w_major;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date w_fndate;
    private String w_com;
    private String w_position;
    private Date w_join;
    private Date w_leave;
    private String w_subject;
    private String w_score;
    private Date w_get;
    private String w_license;
    private Date w_getlicense;
    private String user_id;
}
