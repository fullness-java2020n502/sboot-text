package com.fullnesssboot2.text.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("pathval")
@Controller
public class PathValController {
    @GetMapping("val/{no}")
    public String home(@PathVariable Integer no){
        System.out.println("no:"+no);
        return "pathval";
    }
}
