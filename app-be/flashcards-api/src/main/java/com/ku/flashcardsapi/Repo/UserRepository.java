package com.ku.flashcardsapi.Repo;

import com.ku.flashcardsapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String username);
}
