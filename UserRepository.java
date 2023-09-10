package com.boot.aatral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.aatral.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
