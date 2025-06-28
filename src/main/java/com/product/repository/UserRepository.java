package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
