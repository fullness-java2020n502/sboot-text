package com.fullnesssboot2.text.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("itemAddForm")
@RequestMapping("exercise07")
@Controller
public class Exercise07 {
    @ModelAttribute("itemAddForm")
    public ItemForm setup(){
        return new ItemForm();
    }

    @Autowired
    private PriceValidator priceValidator;

    @InitBinder("itemAddForm")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(priceValidator);
    }

    @GetMapping("enter")
    public String enter(){
        return "exercise07/enter";
    }

    @PostMapping("confirm")
    public String confirm(@Validated @ModelAttribute("itemAddForm") ItemForm itemForm, BindingResult result){
        if(result.hasErrors()) return "exercise07/enter";
        return "exercise07/confirm";
    }

    @PostMapping("complete")
    public String complete(@ModelAttribute("itemAddForm") ItemForm itemForm, SessionStatus sessionStatus, Model model){
        // TODO 登録処理
        model.addAttribute("name",itemForm.getName());
        sessionStatus.setComplete();
        return "exercise07/complete";
    }
}
