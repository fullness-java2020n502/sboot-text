package com.fullnesssboot2.text.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@RequestMapping("model")
@Controller
public class ModelController {
    @GetMapping
    public String home(Model model){
        // 属性を入れる
        model.addAttribute("message","こんにちは");
        model.addAttribute("list",Arrays.asList("hoge","fuga","piyo"));
        return "model";
    }
}
