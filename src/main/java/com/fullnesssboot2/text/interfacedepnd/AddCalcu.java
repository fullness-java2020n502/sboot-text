package com.fullnesssboot2.text.interfacedepnd;

import org.springframework.stereotype.Component;

// 足し算をする目的の実装クラス
@Component // <-これでDI対象になる
public class AddCalcu implements Calculator {
    @Override
    public Integer calc(Integer x, Integer y) {
        return x + y;
    }
}
