package com.example.springbootsecurityprocedureexample.app.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 이승환
 * @since 2022-04-18
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserVO login(UserVO userVO) {
        return null;
    }

    @Override
    public UserVO createUser(UserVO userVO) {
        return null;
    }

    @Override
    public UserVO findUserByUserEmail(String userEmail) {
        return null;
    }
}
