package com.fullnesssboot2.text.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("exercise04")
@Controller
public class Exercise04 {
    @GetMapping
    public String enter(){
        return "exercise04/enter";
    }
    @PostMapping
    public String result(CalcForm calcForm, Model model){
        Integer result = calcForm.getValue1() + calcForm.getValue2();
        model.addAttribute("result",result);
        return "exercise04/result";
    }
}
