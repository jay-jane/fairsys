package com.finalpj.backend.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingVO {
    private int j_no;
    private String j_title;
    private String j_content;
    private String j_salary;
    private String j_department;
    private String j_com_id;
}
