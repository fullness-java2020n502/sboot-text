package com.fullnesssboot2.text.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("empForm")
@RequestMapping("session")
@Controller
public class SessionController {
    // セッションオブジェクトの初期化
    @ModelAttribute("empForm")
    public ValueForm setup(){
        return new ValueForm();
    }
    // 入力画面イベントハンドラ
    @GetMapping("form")
    public String form(){
        return "session/form";
    }
    // 確認画面
    @PostMapping("confirm")
    public String confirm(@ModelAttribute("empForm") ValueForm form){
        return "session/confirm";
    }
    // 完了画面
    @PostMapping("complete")
    public String complete(@ModelAttribute("empForm") ValueForm form, SessionStatus sessionStatus){
        System.out.println(form);
        // TODO formのデータを使ってインサート処理
        // セッション解除
        sessionStatus.setComplete();
        return "session/complete";
    }
}
