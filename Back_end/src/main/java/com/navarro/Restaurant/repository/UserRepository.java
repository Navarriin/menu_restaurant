package com.navarro.Restaurant.repository;

import com.navarro.Restaurant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
