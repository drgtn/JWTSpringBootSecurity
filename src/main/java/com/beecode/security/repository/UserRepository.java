package com.beecode.security.repository;

import com.beecode.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stephan on 20.03.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByLastname(String lastName);
}
