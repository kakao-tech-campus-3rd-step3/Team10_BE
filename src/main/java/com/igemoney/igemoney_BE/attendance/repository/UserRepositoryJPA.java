package com.igemoney.igemoney_BE.attendance.repository;

import com.igemoney.igemoney_BE.attendance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepositoryJPA extends JpaRepository<User, String>{
    Optional<User> findByOauthId(String oauthId);
}
