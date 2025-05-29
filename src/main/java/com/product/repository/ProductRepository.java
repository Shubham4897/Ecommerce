package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.Product;
import com.product.entities.requests.RequestProduct;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product save(RequestProduct reqproduct);

}
