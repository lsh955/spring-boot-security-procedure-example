package com.example.springbootsecurityprocedureexample.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 이승환
 * @since 2022-04-11
 * <p>
 * CustomLoginSuccessHandler 는
 * AuthenticationProvider 를 통해 인증이 성공될 경우 처리
 */
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        // 토큰을 사용하지 않고 세션을 활용하는 현재같은 경우에는
        // 성공하여 반환된 Authentication 객체를 SecurityContextHolder의 Contetx에 저장해주어야 한다.
        // 나중에 사용자 정보를 꺼낼 경우에 SecurityContextHolder의 context에서 조회하면 된다.
        SecurityContextHolder.getContext().setAuthentication(authentication);

        response.sendRedirect("/about"); // 인증이 성공되면 /about redirect 처리
    }
}
