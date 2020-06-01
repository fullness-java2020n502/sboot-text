package com.fullnesssboot2.text.interfacedepnd;

// 呼び出す側のクラス
public class Driver {
    public static void main(String[] args) {
        Calculator calculator = new SubCalcu();
        System.out.println(calculator.calc(4,2));
    }
}
