package com.finalpj.backend.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingVO {
    private String j_no;
    private String j_regdate;
    private String j_recruitNum;
    private String j_email;
    private String j_title;
    private String j_content;
    private String j_end_date;
    private String j_salary;
    private String j_department;
    private String j_schedule;
    private String j_graduation;
    private String j_career;
    private String j_type;
    private String com_id;
}
