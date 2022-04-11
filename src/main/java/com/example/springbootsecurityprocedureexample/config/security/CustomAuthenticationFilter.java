package com.example.springbootsecurityprocedureexample.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 이승환
 * @since 2022-04-11
 * <p>
 * 아이디와 비밀번호를 기반으로
 * UserPasswordAuthenticationToken 을 발급한다.
 */
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getParameter("userEmail"), request.getParameter("userPwc"));
        setDetails(request, authenticationToken);

        // 생성한 UsernamePasswordToken을 AuthenticationManager에게 전달한다.
        // AuthenticationManager은 실제로 인증을 처리할 여러개의 AuthenticationProvider를 가지고 있다.
        return this.getAuthenticationManager().authenticate(authenticationToken);
    }
}
