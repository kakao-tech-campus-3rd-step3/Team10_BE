package com.igemoney.igemoney_BE.user.repository;

import com.igemoney.igemoney_BE.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusRepository extends JpaRepository<User, Long> {

}
