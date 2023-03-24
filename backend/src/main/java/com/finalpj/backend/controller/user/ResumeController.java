package com.finalpj.backend.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.command.UserStatusVO;
import com.finalpj.backend.command.UserVO;
import com.finalpj.backend.service.ResumeService;
import com.finalpj.backend.service.TestService;
import com.finalpj.backend.util.ResumeCriteria;
import com.finalpj.backend.util.ResumeOneGate;
import com.finalpj.backend.util.ResumePageVO;

@RestController
public class ResumeController {
 
    @Autowired
    private ResumeService resumeService;
    
	@Autowired
	@Qualifier("TestService")
	private TestService testService;


    //기업에  지원한 이력서리스트
    @GetMapping("/ApplyStatus")
    public ResumeOneGate list(ResumeCriteria cri, HttpServletRequest request, HttpServletResponse response) {
                //페이지네이션 처리 page - ApplyStatus
                // System.out.println(1);
				String com_id = request.getParameter("com_id");
                int total =  resumeService.getTotal(cri, com_id );
                ResumePageVO pageVO = new ResumePageVO(cri, total);
                // System.out.println(2);
                //게시글 처리
                ArrayList<UserStatusVO> list = resumeService.getList(cri,com_id);
                // System.out.println(3);
                ResumeOneGate ogate = new ResumeOneGate(list, pageVO);
                
                
                // System.out.println(list.toString());
                return ogate;
    }
     
       //지원자 이력서 페이지
       @GetMapping("/ResumeRegist")
       public UserVO ResumeGet(HttpServletRequest request, HttpServletResponse response){
   		   String user_id = request.getParameter("user_id");
   		   UserVO userVO = testService.getUserInfo(user_id);
   		   System.out.println(userVO.toString());
   		   return userVO;
       }
       //지원자 이력서 작성폼
       @PostMapping("/ResumeRegist/submitForm")
       public void ResumeRegist(@RequestBody ResumeWriteVO vo, HttpServletRequest request, HttpServletResponse response){
    	   String user_id = request.getParameter("user_id");
    	   UserVO userVO = testService.getUserInfo(user_id);
    	   System.out.println(userVO.toString());
    	   vo.setUser_id(user_id);
    	   
//           System.out.println(vo.toString());
    	   resumeService.ResumeRegist(vo);
       }
   
       //나의이력서 상세조회
       @GetMapping("/ResumeModify/{user_no}")
       public List<ResumeWriteVO> ResumeModify(@PathVariable(value = "user_no") int user_no)  {
        System.out.println(1);
           List<ResumeWriteVO> list = resumeService.ResumeModify(user_no);
           System.out.println(list.toString());
           return list;
       }
       
       //기업에서 볼때  지원자 이력서 상세조회
       @GetMapping("/ResumeComModify/{user_no}")
       public List<UserStatusVO> ResumeComModify(@PathVariable(value = "user_no") int user_no)  {
        System.out.println(1);
           List<UserStatusVO> list = resumeService.ResumeComModify(user_no);
           System.out.println(list.toString());
           return list;
       }

       
   
       //이력서 수정
      
    //    @PostMapping("/ResumeUpdate")
    //    public void ResumeUpdate(@RequestBody ResumeWriteVO vo) {
    //        System.out.println(1);
    //        System.out.println(vo.toString());
    //        resumeService.ResumeUpdate(vo);    
    //    }
    
      




        //지원자 이력서 마이페이지
        @GetMapping("/UserMyPage")
        public ArrayList<UserStatusVO> UserMyPage (HttpServletRequest request, HttpServletResponse response){
    
    		String user_id = request.getParameter("user_id");
    		System.out.println(user_id);

            ArrayList<UserStatusVO> resumeWriteVO = resumeService.UserMyPage(user_id);
            
            System.out.println(resumeWriteVO.toString());
         
            return resumeWriteVO;
        }
  
        //지원자 이력서 수정
      @PostMapping("/ResumeUpdate/updateForm")
      public void ResumeUpdate(@RequestBody ResumeWriteVO vo, HttpServletRequest request, HttpServletResponse response){
          String user_id = request.getParameter("user_id");
          UserVO userVO = testService.getUserInfo(user_id);
//          System.out.println(userVO.toString());
          vo.setUser_id(user_id);
          
        // System.out.println(vo.toString());
          resumeService.ResumeUpdate(vo);
      }

        
        //이력서 삭제
        @PostMapping("/ResumeDelete")
        public void delete(@RequestBody UserStatusVO vo) {
            System.out.println(vo.getUser_no());
            resumeService.delete(vo.getUser_no());
                
        }

        //이력서 진행 상황 갱신
        @PostMapping("/updateStatus")
        public void updateStatus(@RequestBody UserStatusVO vo) {
            System.out.println(vo.getUser_no());
            System.out.println(vo.getStatus());
            System.out.println(vo.getCom_id());
            resumeService.updateStatus(vo);
        }

       
    @GetMapping("/getUserVO/{user_id}")
    public List<UserVO> getUserVO(HttpServletRequest request, HttpServletResponse response) {
        String user_id = request.getParameter("user_id");
        List<UserVO> list = resumeService.getUserVO(user_id);
        return list;
    }

}