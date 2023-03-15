package com.finalpj.backend.command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyVO {

    private String com_id;
    private String com_pw;
    private String com_num;
    private String com_category;
    private String com_ceo;
    private String com_postcode;
    private String com_address;
    private String com_detail_address;
    private String com_manager;
    private String com_manager_phone;
    private String com_name;
    private String com_status;
    private String com_email;
    private String ut_no;
    private int cno;
    private String com_registration_date;
    private String com_Application_date;

}
