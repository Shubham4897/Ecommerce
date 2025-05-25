package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.SubCategory;

public interface SubRepository extends JpaRepository<SubCategory, Long> {

}
