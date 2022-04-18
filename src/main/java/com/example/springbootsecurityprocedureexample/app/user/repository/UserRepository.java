package com.example.springbootsecurityprocedureexample.app.user.repository;

import com.example.springbootsecurityprocedureexample.app.user.model.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author 이승환
 * @since 2022-04-18
 */
@Repository
public interface UserRepository extends JpaRepository<UserVO, Long> {

    UserVO findByUserEmailAndUserPw(String userId, String userPw);

    Optional<UserVO> findByUserEmail(String userEmail);
}
