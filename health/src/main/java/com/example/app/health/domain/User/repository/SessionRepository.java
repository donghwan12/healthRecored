package com.example.app.health.domain.User.repository;

import com.example.app.health.domain.User.Entity.session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<session,String> {
}
