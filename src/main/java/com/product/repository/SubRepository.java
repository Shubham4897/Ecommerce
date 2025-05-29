package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.SubCategory;
import com.product.entities.requests.RequestSubCategory;

public interface SubRepository extends JpaRepository<SubCategory, Long> {

	SubCategory save(RequestSubCategory subCategory);

}
