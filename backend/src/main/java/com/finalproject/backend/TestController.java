package com.finalproject.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    
    @RequestMapping({"/page1", "/page2", "/page14", "/page15", "/page12"})
    public void page1(){

       
    }

    // @RequestMapping(value = "/page2", method = RequestMethod.GET)
    // public String page2(){

    //     return "page2";
    // }


}