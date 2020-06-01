package com.fullnesssboot2.text.bean;

import org.springframework.stereotype.Component;

@Component
public class EveningGreet implements Greetable{
    @Override
    public void say(String name) {
        System.out.println(name+"さん、こんばんは");
    }
}
