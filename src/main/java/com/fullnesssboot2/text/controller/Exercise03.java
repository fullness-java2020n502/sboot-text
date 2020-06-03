package com.fullnesssboot2.text.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("exercise03")
@Controller
public class Exercise03 {
    @GetMapping
    public String enter(){
        return "exercise03/enter";
    }
    @PostMapping
    public String confirm(ValueForm valueForm){
        return "exercise03/result";
    }
}
