package com.product.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.product.entities.Brand;
import com.product.entities.Product;
import com.product.entities.SubCategory;


public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByBrand(Brand brand);

	List<Product> findByBrand(SubCategory subCategory);

}
