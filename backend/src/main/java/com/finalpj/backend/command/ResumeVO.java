package com.finalpj.backend.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeVO {
    private int r_no;
    private String r_title;
    private String r_name;
    private String r_gender;
}
