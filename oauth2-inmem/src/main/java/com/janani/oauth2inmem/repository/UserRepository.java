package com.janani.oauth2inmem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.janani.oauth2inmem.entity.User;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
