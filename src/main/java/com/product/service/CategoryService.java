package com.product.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.entities.Category;
import com.product.repository.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryrepo;
	
	public List<Category> GetAllCategory() {
		// TODO Auto-generated method stub
		return categoryrepo.findAll();
	}

	

	public ResponseEntity<?> createCategory(Category category) {
		if(category.getCategoryName()==null||category.getCategoryName().isEmpty()||category.getCategoryName().isBlank()) {
			return ResponseEntity.ok("this field should Not be emptu or null");
		}
		
		category.setCreatedCategoryDate(createCategoryDate());
		categoryrepo.save(category);
		return ResponseEntity.ok("Category Saved successfully");

	
	}
	public String updateProdById(Long id, Category category) {
		Optional<Category> cate=categoryrepo.findById(id);
		if(cate.isPresent()) {
			Category exisiting=cate.get();
			exisiting.setCategoryName(category.getCategoryName());
			exisiting.setUpdatedCategoryDate(createCategoryDate());
			categoryrepo.save(exisiting);
			return "Category"+id;
			
			
		}
		return "Category Not added";
	}

	public String deleteCatById(Long id) {
		categoryrepo.deleteById(id);
		return "Deleted SuccessFully";
		
		
	}
	
	public String createCategoryDate() {
        // Create date formatter
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Get current date
        Date date = new Date();

        // Format date to string
        String formattedDate = formatter.format(date);

        // Print or use the formatted date string
       return formattedDate;
    }
	
	

}
