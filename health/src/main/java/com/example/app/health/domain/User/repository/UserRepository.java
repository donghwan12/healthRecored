package com.example.app.health.domain.User.repository;

import com.example.app.health.domain.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findByname(String WorkoutDto);
}
