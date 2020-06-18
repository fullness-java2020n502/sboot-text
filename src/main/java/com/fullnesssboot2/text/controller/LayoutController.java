package com.fullnesssboot2.text.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/layout")
@Component
public class LayoutController {
    @GetMapping
    public String layout(){
        return "layout/menu";
    }
}
