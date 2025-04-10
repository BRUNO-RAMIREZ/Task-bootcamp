package com.dhasset.auth_service.model.repository;

import com.dhasset.auth_service.model.domain.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Bruno Ramirez
 **/
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    Optional<AuthUser> findByUserName(String userName);
}
