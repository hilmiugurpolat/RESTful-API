package com.example.demo2.api.repository;

import com.example.demo2.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
@Component

public interface UserRepository extends JpaRepository<User, Integer> {
}