package com.example.springbootsecurityprocedureexample.app.user.service;

import com.example.springbootsecurityprocedureexample.app.user.model.UserDetailsVO;
import com.example.springbootsecurityprocedureexample.app.user.repository.UserRepository;
import com.example.springbootsecurityprocedureexample.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author 이승환
 * @since 2022-04-18
 */
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsVO loadUserByUsername(String userEmail) {
        return userRepository.findByUserEmail(userEmail).map(u ->
                new UserDetailsVO(u, Collections.singleton(
                        new SimpleGrantedAuthority(u.getRole().getValue())
                ))).orElseThrow(() ->
                new UserNotFoundException(userEmail)
        );
    }
}
