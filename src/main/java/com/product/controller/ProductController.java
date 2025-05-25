package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entities.Product;
import com.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService prodservice;
	
	@RequestMapping("/getProductList")
	public List<Product> getAllProductList(){
		return prodservice.getAllProducts();
	}
	
	
	@PostMapping("/createProduct")
	public Product createProd(@RequestBody Product product) {
		return prodservice.CreateProduct(product);
	}
	@RequestMapping("/getProduct/{id}")
	public Optional<Product> getById(@PathVariable Long id) {
		return prodservice.productById(id);
	}
	@PutMapping("/updateProduct/{id}")
	public String updateById(@PathVariable Long id, @RequestBody Product product) {
		return prodservice.updateProdById(id,product);
}
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteById(@PathVariable Long id) {
		return prodservice.deleteProdById(id);	
	}
}
