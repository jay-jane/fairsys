package com.finalpj.backend.command;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentQnaVO {

    private int qa_no;
    private String qa_title;
    private String qa_content;
    private Date qa_date;
    private String user_id;
    private String com_id;
    private String qa_answer;
}