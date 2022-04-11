package com.example.springbootsecurityprocedureexample.config.web;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author 이승환
 * @since 2022-04-11
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        // 정적 자원에 대해서는 Security 설정을 적용하지 않음
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }


}
