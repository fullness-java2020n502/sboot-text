package com.fullnesssboot2.text.interfacedepnd;

import org.springframework.stereotype.Component;

// 引き算をする目的のクラス
@Component
public class SubCalcu implements Calculator{
    @Override
    public Integer calc(Integer x, Integer y) {
        return x - y;
    }
}
