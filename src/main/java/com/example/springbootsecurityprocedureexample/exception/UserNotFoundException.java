package com.example.springbootsecurityprocedureexample.exception;

/**
 * @author 이승환
 * @since 2022-04-18
 *
 * 사용자의 아이디를 기반으로
 * 데이터가 조회하지 않았을 경우 처리해주기 위한 Exception 클래스
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userEmail){
        super(userEmail + " NotFoundException");
    }
}
