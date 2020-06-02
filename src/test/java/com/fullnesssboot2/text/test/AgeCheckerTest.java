package com.fullnesssboot2.text.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AgeCheckerTest {
    @Autowired
    AgeChecker ageChecker;
    @Test
    void testCase1() throws Exception{
        Assertions.assertEquals(1,ageChecker.check(19));
    }
    @Test
    void testCase2() throws Exception{
        Assertions.assertEquals(2,ageChecker.check(20));
    }
    @Test
    void testCase3() throws Exception{
        Assertions.assertEquals(2,ageChecker.check(64));
    }
    @Test
    void testCase4() throws Exception{
        Assertions.assertEquals(3,ageChecker.check(65));
    }
    @Test
    void testCase5() throws Exception{
        try {
            ageChecker.check(-1); // 例外発生する事を期待
            Assertions.fail(); // ここまで到達したらテスト失敗とみなす
        }catch (Exception e){
            // ここにこれたらテスト合格
            Assertions.assertEquals(1,1); // テスト合格になる評価
        }
    }
}
