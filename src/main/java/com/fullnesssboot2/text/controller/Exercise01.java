package com.fullnesssboot2.text.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exercise01")
public class Exercise01 {
    @GetMapping("hello") // http://localhost:8080/exercise01/helloで受け付けるメソッド
    public String hello(){
        return "exercise01/hello"; // resources/templates/exercise01/hello.htmlのViewを呼び出す
    }
}
