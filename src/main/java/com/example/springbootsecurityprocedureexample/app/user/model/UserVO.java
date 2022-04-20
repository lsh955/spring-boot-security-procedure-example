package com.example.springbootsecurityprocedureexample.app.user.model;

import com.example.springbootsecurityprocedureexample.app.common.model.CommonVO;
import com.example.springbootsecurityprocedureexample.enums.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 이승환
 * @since 2022-04-18
 */
@NoArgsConstructor
@Entity
@Table(name = "USER")
@Getter
public class UserVO extends CommonVO implements Serializable {

    @Setter
    @Column(nullable = false, unique = true, length = 50)
    private String userEmail;

    @Setter
    @Column(nullable = false)
    private String userPw;

    @Setter
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public UserVO(String userEmail, String userPw) {
        this.userEmail = userEmail;
        this.userPw = userPw;
    }
}
