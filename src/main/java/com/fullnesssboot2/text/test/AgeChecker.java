package com.fullnesssboot2.text.test;

import org.springframework.stereotype.Component;

@Component
public class AgeChecker {
    public Integer check(Integer age) throws Exception {
        if (age < 0) throw new Exception();
        if (age < 20) return 1;
        if (age >= 65) return 3;
        return 2;
    }
}
