package com.product.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entities.Brand;
import com.product.entities.Category;
import com.product.entities.requests.BrandUpdateRequest;
import com.product.repository.BrandRepository;
import com.product.repository.CategoryRepo;

@Service
public class BrandService {
	@Autowired
	private BrandRepository brandrepo;
	
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Brand> getBrandList() {
		return brandrepo.findAll();

	}

	public Brand CreateBrand(Brand brand) {
		brand.setCreateDate(createBrandDate());
		return	brandrepo.save(brand);
		 
	}

	public String updateBrand(Long id, BrandUpdateRequest request) {
				Optional<Brand> b1=brandrepo.findById(id);
			    Optional<Category> categoryOpt = categoryRepo.findById(request.getCategoryId());

				if(b1.isPresent()) {
					Brand exist = b1.get();
			        exist.setBrandName(request.getBrandName());
			        exist.setUpdateDate(createBrandDate());
			        exist.setCategory(categoryOpt.get());
				brandrepo.save(exist);
				return "Brand updated "+id;
				}
		return "Not updated "+id;
		// TODO Auto-generated method stub
		
	}
	
	
//	public String updateBrand(Long id, BrandUpdateRequest request) {
//	    Optional<Brand> b1 = brandrepo.findById(id);
//	    Optional<Category> categoryOpt = categoryRepo.findById(request.getCategoryId());
//
//	    if (b1.isPresent() && categoryOpt.isPresent()) {
//	        Brand exist = b1.get();
//	        exist.setBrandName(request.getBrandName());
//	        exist.setUpdateDate(createBrandDate());
//	        exist.setCategory(categoryOpt.get());
//
//	        brandrepo.save(exist);
//	        return "Brand updated " + id;
//	    }
//
//	    return "Not updated " + id;
//	}


	public String DeleteBrandById(Long id) {
				brandrepo.deleteById(id);
		return id+" deleted Successfully";
		// TODO Auto-generated method stub
		
	}
	
	public String createBrandDate() {
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
