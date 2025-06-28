package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entities.Category;
import com.product.service.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Add this annotation
public class CategoryController {
	@Autowired
	private CategoryService services;
	
	@GetMapping("/getCategoryList")
	public List<Category> GetAllCat() {
		return services.GetAllCategory();
	}
	
	@PostMapping("/createCategory")
	public ResponseEntity<?> createCategory(@RequestBody Category category) {
		return ResponseEntity.ok(services.createCategory(category));
		//return services.CreateCategory(category);	
	}
	@PutMapping("/updateCategory/{id}")
	public String updateById(@PathVariable Long id, @RequestBody Category category) {
		return services.updateProdById(id,category);
}
	@DeleteMapping("/deleteCategory/{id}")
	public String deleteById(@PathVariable Long id) {
		services.deleteCatById(id);
		return "";	
	}


}
