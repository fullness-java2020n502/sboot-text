package com.fullnesssboot2.text.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("exercise05")
@SessionAttributes(names="calcForm")
public class Exercise05 {
    @ModelAttribute
    public CalcForm setUpForm(){
        return new CalcForm();
    }
    @GetMapping
    public String enter(){
        return "exercise05/enter";
    }
    @PostMapping
    public String result(CalcForm calcForm, Model model){
        Integer result = calcForm.getValue1()+calcForm.getValue2();
        model.addAttribute("result",result);
        return "exercise05/result";
    }
    @PostMapping(params="clear")
    public String clear(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "redirect:/exercise05";
    }
    @PostMapping(params="back")
    public String back(){
        return "exercise05/enter";
    }
}

