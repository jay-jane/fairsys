package com.finalpj.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JyTestController {
    
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/getCategoryChild")
    public String getCategoryChild() {
        return "asdf";
    }

}
