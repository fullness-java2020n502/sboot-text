package com.fullnesssboot2.text.controller;

import com.fullnesssboot2.text.entity.Item;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String confirm(
            @Validated @ModelAttribute("empForm") ValueForm form,
            BindingResult result // <-入力チェックを実施した結果を取得
    ){
        // エラー時に入力画面に戻す
        if(result.hasErrors()) return "session/form";
        return "session/confirm";
    }
    // 完了画面
    @PostMapping("complete")
    public String complete(@ModelAttribute("empForm") ValueForm form, SessionStatus sessionStatus){
        System.out.println(form);
        // TODO formのデータを使ってインサート処理
        ModelMapper modelMapper = new ModelMapper();
        Item item = modelMapper.map(form, Item.class);
        // セッション解除
        sessionStatus.setComplete();
        return "session/complete";
    }
}
