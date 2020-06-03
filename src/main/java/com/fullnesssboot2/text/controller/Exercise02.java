package com.fullnesssboot2.text.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("exercise02")
@Controller
public class Exercise02 {

    @GetMapping
    public String home(){
        return "exercise02/home";
    }
    @GetMapping("forward")
    public String forward(){
        return "exercise02/first";
    }
    @GetMapping("second")
    public String second(){
        return "exercise02/second";
    }
    @GetMapping("redirect")
    public String redirect(){
        // ここの「/」はhttp://localhost:8080/ <- これ
        return "redirect:/exercise01/hello";
    }
}
