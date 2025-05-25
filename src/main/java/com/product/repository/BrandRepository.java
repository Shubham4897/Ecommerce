package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long>{

}
