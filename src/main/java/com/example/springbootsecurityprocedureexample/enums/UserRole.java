package com.example.springbootsecurityprocedureexample.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 이승환
 * @since 2022-04-18
 */
@AllArgsConstructor
@Getter
public enum UserRole {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN")
    ;

    private final String value;
}
