package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entities.Brand;
import com.product.service.BrandService;

@RestController
public class BrandController {
	@Autowired
	private BrandService brandservice;
	
	@GetMapping("/getBrandList")
	public List<Brand> GetBrands(){
		return brandservice.getBrandList();
	}
	@PostMapping("/createBrand")
	public Brand createBrand(@RequestBody Brand brand) {
		return brandservice.CreateBrand(brand);
		 
	}
	@PutMapping("/updateBrand/{id}")
	public String editBrand(@PathVariable Long id, @RequestBody Brand brand) {
					brandservice.updateBrand(id, brand);
					return "Brand Added";
	}
	@DeleteMapping("/deleteBrand/{id}")
	public String deleteBrand(@PathVariable Long id) {
		 brandservice.DeleteBrandById(id);
		return id+" deleted Successfully";
	}

}
