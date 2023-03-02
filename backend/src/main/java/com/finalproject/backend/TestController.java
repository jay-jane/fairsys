package com.finalproject.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    
    @RequestMapping(value = "/page1", method = RequestMethod.GET)
    public String page1(){

        return "page1";
    }

    @RequestMapping(value = "/page2", method = RequestMethod.GET)
    public String page2(){

        return "page2";
    }
}
