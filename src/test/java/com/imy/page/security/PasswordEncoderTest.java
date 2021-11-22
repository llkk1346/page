package com.imy.page.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("패스워드 암호화 테스트")
    void passwordEncode() {
        //given
        String testPassword = "12345678";

        //when
        String encodedPassword = passwordEncoder.encode(testPassword);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotEquals(testPassword, encodedPassword), //평문 패스워드와 암호화 패스워드가 서로 다른게 맞는지
                () -> Assertions.assertTrue(passwordEncoder.matches(testPassword, encodedPassword))
                //matches 두 문자열 비교 메소드
                //matches() 내부에서 평문 패스워드와 암호화된 패스워드가 서로 대칭되는지에 대한 알고리즘을 구현하고 있기 때문에 가능.

        );
    }
}
