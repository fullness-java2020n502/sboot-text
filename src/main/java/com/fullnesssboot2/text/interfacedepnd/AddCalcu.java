package com.fullnesssboot2.text.interfacedepnd;

// 足し算をする目的の実装クラス
public class AddCalcu implements Calculator {
    @Override
    public Integer calc(Integer x, Integer y) {
        return x + y;
    }
}
