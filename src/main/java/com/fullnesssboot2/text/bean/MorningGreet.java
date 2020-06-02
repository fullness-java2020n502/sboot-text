package com.fullnesssboot2.text.bean;

import org.springframework.stereotype.Component;

@Component
public class MorningGreet {
    public void say(String name){
        System.out.println(name+"さん、おはようございます");
    }

    public int add(int x, int y){
        return x + y;
    }
}
