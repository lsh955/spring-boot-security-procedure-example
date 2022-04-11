package com.example.springbootsecurityprocedureexample.config.security;

import com.example.springbootsecurityprocedureexample.app.UserDetailsVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 이승환
 * @since 2022-04-11
 * <p>
 * AuthenticationManager 에서 전달받은
 * UsernamePasswordToken 을 순차적으로 AuthenticaionProvider 에게 전달하여 실제 인증 과정을 수행
 */
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 실제 인증에 대한 부분은 authenticate 메서드에서 처리
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

        // AuthenticaionFilter 에서 생성된 토큰으로부터 아이디와 비밀번호를 조회한다.
        String userEmail = token.getName();
        String userPw = (String) token.getCredentials();

        // UserDetailsService를 통해 DB에서 아이디로 사용자 조회
        UserDetailsVO userDetailsVO = (UserDetailsVO) userDetailsService.loadUserByUsername(userEmail);

        if (!bCryptPasswordEncoder.matches(userPw, userDetailsVO.getPassword()))
            throw new BadCredentialsException(userDetailsVO.getUsername() + "Invalid password");

        return new UsernamePasswordAuthenticationToken(userDetailsVO, userPw, userDetailsVO.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
