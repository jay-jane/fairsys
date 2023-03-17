package com.finalpj.backend.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStatusVO {
    private String user_id;
    private String com_id;
    private String user_name;
    private String gender;
    private String status;
    private int w_no;
}