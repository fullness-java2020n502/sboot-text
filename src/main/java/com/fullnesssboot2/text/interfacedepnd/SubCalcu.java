package com.fullnesssboot2.text.interfacedepnd;

// 引き算をする目的のクラス
public class SubCalcu implements Calculator{
    @Override
    public Integer calc(Integer x, Integer y) {
        return x - y;
    }
}
