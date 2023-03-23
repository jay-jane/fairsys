package com.finalpj.backend.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantsbyDateVO {
    
    private String date;
    private int count;

}
