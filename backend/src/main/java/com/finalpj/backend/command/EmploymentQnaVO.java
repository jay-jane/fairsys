package com.finalpj.backend.command;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentQnaVO {

    private int qa_no;              //자동생성 번호
    private String qa_title;        //제목
    private String qa_content;      //내용
    private Date qa_date;           //날짜
    private String user_id;         //유저 아이디
    private String com_id;          //회사 아이디  
    private String qa_answer;       //문의 답변
    private String qa_answertype;    //답변결과
}