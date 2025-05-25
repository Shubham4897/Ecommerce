package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
