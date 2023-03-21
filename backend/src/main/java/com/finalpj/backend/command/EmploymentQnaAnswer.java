package com.finalpj.backend.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentQnaAnswer {
    
    private int qaa_no;
    private String com_id;
    private String qaa_content;
    private int q_no;
}
