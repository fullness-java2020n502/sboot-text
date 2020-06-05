package com.fullnesssboot2.text;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PasswordTest {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void testPasswordEncoder(){
        String encodedPassword = passwordEncoder.encode("hogehoge");
        System.out.println(encodedPassword);
    }
}
