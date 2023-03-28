package com.finalpj.backend.controller.company;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.finalpj.backend.command.CompanyVO;
import com.finalpj.backend.command.JobPostingVO;
import com.finalpj.backend.command.ResumeWriteVO;
import com.finalpj.backend.command.UserStatusVO;
import com.finalpj.backend.service.CompanyService;
import com.finalpj.backend.util.JobCriteria;
import com.finalpj.backend.util.JobOneGate;
import com.finalpj.backend.util.JobPageVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JobPostingController {

    private final CompanyService service;

    @GetMapping("/4")
    public JobOneGate list(JobCriteria jcri) {
        //페이지네이션 처리
        int total =  service.getTotal(jcri);
        JobPageVO pageVO = new JobPageVO(jcri, total);
        //게시글 처리
        List<JobPostingVO> list = service.getJobList(jcri);
        JobOneGate ogate = new JobOneGate(list, pageVO);
        return ogate;
    }

    @GetMapping("/getTotal")
    public int getTotal(JobCriteria jcri) {
        return service.getTotal(jcri);
    }

    @GetMapping("/checkPosting")
    public int checkPosting(@RequestParam("com_id") String com_id) {
        return service.checkPosting(com_id);
    }
    @PostMapping("/jobPostingRegist")
    public void regist(@RequestBody JobPostingVO vo) {
        service.regist(vo);
    }

    @GetMapping("/jobPostingDetail/{j_no}")
    public List<JobPostingVO> getJobDetail(@PathVariable(value = "j_no", required = false) int j_no) {
        List<JobPostingVO> list = service.getJobDetail(j_no);
        return list;
    }

    @PostMapping("/jobPostingUpdate")
    public void update(@RequestBody JobPostingVO vo) {
        service.update(vo);
    }

    @PostMapping("/jobPostingDelete")
    public void delete(@RequestBody JobPostingVO vo) {
        service.delete(vo.getJ_no());
    }

    @GetMapping("/checkApply")
    public int checkApply(@RequestParam("user_id") String user_id, @RequestParam("com_id") String com_id) {
        // System.out.println(service.checkApply(user_id, com_id));
        // System.out.println(user_id);
        return service.checkApply(user_id, com_id);
    }
    @GetMapping("/apply")
    public ResumeWriteVO apply(HttpServletRequest request, HttpServletResponse response) {
        String user_id = request.getParameter("user_id");
        // System.out.println(user_id);
        return service.apply(user_id);
    }
    @PostMapping("/applyInsert")
    public void applyInsert(@RequestBody UserStatusVO vo) {
        // System.out.println(vo.toString());
        service.applyInsert(vo);
    }

    @GetMapping("/getCompanyVO/{com_id}")
    public List<CompanyVO> getCompanyVO(HttpServletRequest request, HttpServletResponse response) {
        String com_id = request.getParameter("com_id");
        List<CompanyVO> list = service.getCompanyVO(com_id);
        return list;
    }

    @GetMapping("/getJno")
    public String getJno(HttpServletRequest request, HttpServletResponse response) {
        String com_id = request.getParameter("com_id");
        return service.getJno(com_id);
    }
    // MultipartFile file
    @PostMapping("/uploadImg")
    public void upload(HttpServletRequest request, MultipartFile file) {
        String uploadPath = "C:\\Users\\sk223\\Desktop\\course\\Final_Project_FairSys\\frontend\\src\\img\\";
        String originalName = file.getOriginalFilename();
        String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
        String uuid = UUID.randomUUID().toString();
        String savefileName = uploadPath + File.separator + uuid + "_" + fileName;
        Path savePath = Paths.get(savefileName);
        String com_id = request.getParameter("com_id");
        System.out.println(uuid);
        System.out.println(fileName);
        System.out.println(com_id);
        try {
            file.transferTo(savePath);
            service.uploadImg(uuid, fileName, com_id);
            System.out.println("업로드, db작업 완료");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("이미지 DB 업로드 실패");
        }
    }

}
