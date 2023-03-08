package com.finalproject.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JyTestController {
    
    @GetMapping("/page8")
    public String data() {
        String str = "ㅎㅇ";
        return str;
    }

}
