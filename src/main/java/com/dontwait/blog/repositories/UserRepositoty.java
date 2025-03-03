package com.dontwait.blog.repositories;

import com.dontwait.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<User, Integer> {
    boolean existsByName(String username);
    boolean existsByEmail(String email);
}
