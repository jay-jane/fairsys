package com.finalpj.backend.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingVO {
    private int j_no;
    private String j_regdate;
    private String j_recruitNum;
    private String j_email;
    private String j_title;
    private String j_content;
    private Timestamp j_end_date;
    private String j_salary;
    private String j_department;
    private String j_schedule;
    private String j_graduation;
    private String j_career;
    private String j_type;
    private String j_postcode;
    private String j_address;
    private String j_detail_address;

    private String com_id;
    private String com_name;
    private String com_ceo;
    private String com_manager;
    private String com_manager_phone;
    private String com_address;
    private String com_detail_address;
}
