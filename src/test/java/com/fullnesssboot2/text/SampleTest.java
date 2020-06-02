package com.fullnesssboot2.text;

import com.fullnesssboot2.text.bean.Greetable;
import com.fullnesssboot2.text.bean.MorningGreet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// 1. テストクラス名の上にExtendWith,SpringBootTestのアノテーションを追加
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SampleTest {
    // SpringのDIができるようになる
    @Autowired
    MorningGreet morningGreet;
    @Test
    void testSay(){
        morningGreet.say("山田");
    }
    @Test
    void testAdd(){
        Assertions.assertEquals(5, morningGreet.add(2,3));
    }
}
