package com.finalpj.backend.command;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingVO {
    private int j_no;
    private String j_regdate;
    // @NotBlank
    private String j_recruitNum;
    // @Email
    private String j_email;
    // @NotBlank
    private String j_title;
    private String j_content;
    // @Future
    private LocalDateTime j_end_date;
    // @NotBlank
    private String j_salary;
    // @NotBlank
    private String j_department;
    // @NotBlank
    private String j_schedule;
    // @NotBlank
    private String j_graduation;
    // @NotBlank
    private String j_career;
    // @NotBlank
    private String j_type;
    // @NotBlank
    private String j_postcode;
    // @NotBlank
    private String j_address;
    // @NotBlank
    private String j_detail_address;
    private String com_id;
    
    private String j_img_uuid;
    private String j_img_fileName;
    
    private CompanyVO companyVO;
    private String com_name;
    // private String com_ceo;
    // private String com_category;
    // private String com_manager;
    // private String com_manager_phone;
    // private String com_address;
    // private String com_detail_address;
}
