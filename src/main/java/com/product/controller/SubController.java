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

import com.product.entities.SubCategory;
import com.product.service.SubService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Add this annotation
public class SubController {
	@Autowired
	private SubService subservice;
	
	@GetMapping("/getSubList")
	public List<SubCategory> getAll(){
		return subservice.getSubAll();
	}
	@PostMapping("/CreateSub")
	public SubCategory create(@RequestBody SubCategory subcategory ) {
		return subservice.CreateSubCategory(subcategory);
	}
	@PutMapping("/edit/{id}")
	public String editSub(@PathVariable Long id, @RequestBody SubCategory subcategory) {
		return subservice.UpdateSub(id,subcategory);
	
	}
	@DeleteMapping("/delete/{id}")
	public String deleteSub(@PathVariable Long id) {
			return subservice.deleteSub(id);
	}

}
