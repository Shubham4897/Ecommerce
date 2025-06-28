package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.CartManager;

public interface CartRepository extends JpaRepository<CartManager, Long> {

}
