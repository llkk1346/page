package com.imy.page.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity //이 클래스로 생성된 객체는 시큐리티 설정파일을 의미, 동시에 시큐리티에 필요한 객체들을 생성
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //WebSecurityConfigurerAdapter 클래스를 빈으로 설정하기만 해도 애플리케이션은 로그인을 강제하지 않음
    @Override //시큐리티와 관련된 설정시 configure 메소드 사용
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
                .csrf().disable()
                .formLogin().disable()
                .headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
