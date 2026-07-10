package com.app.todo.auth.repository;

import com.app.todo.auth.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthUserRepository extends JpaRepository<AuthUser, UUID> {
}
