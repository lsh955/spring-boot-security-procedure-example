package com.example.springbootsecurityprocedureexample.app.user.service;

import com.example.springbootsecurityprocedureexample.app.user.model.UserVO;

/**
 * @author 이승환
 * @since 2022-04-18
 */
public interface UserService {

    UserVO login(UserVO userVO);

    UserVO createUser(UserVO userVO);

    UserVO findUserByUserEmail(String userEmail);
}
