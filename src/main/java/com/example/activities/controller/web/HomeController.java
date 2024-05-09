package com.example.activities.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/index")
    public String index(){

        return "index";
    }
    @GetMapping("/success")
    public String success(){
        return "success";
    }
}
