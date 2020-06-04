package com.fullnesssboot2.text.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exercise06")
public class Exercise06 {
    @ModelAttribute
    public CalcForm setup(){
        return new CalcForm();
    }
    @GetMapping
    public String enter(){
        return "exercise06/enter";
    }
    @PostMapping
    public String result(@Validated CalcForm calcForm, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "exercise06/enter"; }
        Integer result = calcForm.getValue1()+calcForm.getValue2(); model.addAttribute("result",result);
        return "exercise06/result";
    }
}
