package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entities.Product;
import com.product.entities.requests.RequestProduct;
import com.product.service.ProductService;



@RestController
@CrossOrigin(origins = "http://localhost:3000") // Add this annotation
public class ProductController {
	
	@Autowired
	private ProductService prodservice;
	
	
	@PostMapping("/createProduct")
	public Product createProd(@RequestBody RequestProduct reqproduct) {
		return prodservice.CreateProduct(reqproduct);
	}

	
	
	@GetMapping("/getProductList")
	public List<Product> getAllProductList(){
		return prodservice.getAllProducts();
	}
	
	
//	@PostMapping("/createProduct")
//	public Product createProd(@RequestBody Product product) {
//		
//		return prodservice.CreateProduct(product);
//	}
	
	@PutMapping("/updateProduct/{id}")
	public String updateById(@PathVariable Long id, @RequestBody RequestProduct product) {
		return prodservice.updateProdById(id,product);
}
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteById(@PathVariable Long id) {
		return prodservice.deleteProdById(id);	
	}
}
