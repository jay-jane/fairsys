

package com.finalpj.backend.controller.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.EmploymentQnaVO;
import com.finalpj.backend.service.EmploymentQnaService;
import com.finalpj.backend.util.Criteria;
import com.finalpj.backend.util.OneGate;
import com.finalpj.backend.util.PageVO;


@RestController
public class EmploymentQnaController {
    
    @Autowired
    private EmploymentQnaService eqs;



    @GetMapping("/11/")
    public  OneGate<EmploymentQnaVO> list (@RequestParam("user_id") String user_id, 
                                           @RequestParam("com_id") String com_id,
                                           Criteria cri){
        
        System.out.println(user_id);
        System.out.println(com_id);

        ArrayList<EmploymentQnaVO> list = new ArrayList<>();
        OneGate<EmploymentQnaVO> ogate = new OneGate<>();
        
        int total = 0;
        PageVO pageVO = new PageVO(cri, total);
        
        //리스트확인하려는 사람이 유저라면
        if (com_id.equals("")) {
            
            total = eqs.getTotal(user_id, cri);
            pageVO = new PageVO(cri, total);

            list = eqs.getList(user_id, cri);
            ogate = ogate.test(list, pageVO);

            //System.out.println(ogate.toString());

        //리스트를 확인하려는 사람이 기업이라면
        } else if (user_id.equals("")) {

            //System.out.println(1);

            total = eqs.getCompanyTotal(com_id, cri);
            pageVO = new PageVO(cri, total);

            list = eqs.getCompanyList(com_id, cri);
            ogate = ogate.test(list, pageVO);

            //System.out.println(ogate.toString());
        }

        return ogate;
    }  

    @GetMapping("/12/{qa_no}")
    public ArrayList<EmploymentQnaVO> qnaDetail(@PathVariable("qa_no") int qa_no, 
                                                @RequestParam String user_id,
                                                @RequestParam String com_id){
        
        // System.out.println(user_id);
        // System.out.println(com_id);   

        ArrayList<EmploymentQnaVO> list = new ArrayList<>();
        
        //유저가 정보를 요청했다면
        if(com_id.equals("")){

            list = eqs.getDetail(qa_no, user_id);
    
        //기업이 상세내용을 요청했다면
        }else if(user_id.equals("")){

            list = eqs.getDetailCompany(qa_no, com_id);
            //System.out.println(list.toString());

        }
        //System.out.println(list.toString());

        return list;
    }


    @GetMapping("/13")
    public ArrayList<CompanyVO> myCompany(@RequestParam("user_id") String user_id){

        System.out.println("문의작성" + user_id);
        ArrayList<CompanyVO> list = eqs.getComName(user_id);

        return list;
    }


    @PostMapping("/13")
    public void write(@RequestBody EmploymentQnaVO vo){
        //System.out.println("실행쓰");
        //System.out.println(vo.toString());
        eqs.regist(vo);
    }

    @PostMapping("/12_doRegistAnswer")
    public void registAnswer(@RequestBody EmploymentQnaVO vo){
        eqs.registAnswer(vo);
    }
    
    
}
