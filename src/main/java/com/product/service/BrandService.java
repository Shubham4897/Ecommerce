package com.product.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entities.Brand;
import com.product.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	private BrandRepository brandrepo;
	
	public List<Brand> getBrandList() {
		return brandrepo.findAll();

	}

	public Brand CreateBrand(Brand brand) {
		brand.setBrandName(brand.getBrandName());
		brand.setCreateDate(createBrandDate());
		return	brandrepo.save(brand);
		 
	}

	public String updateBrand(Long id, Brand brand) {
						Optional<Brand> obj=brandrepo.findById(id);

				if(obj.isPresent()) {
					Brand exist = obj.get();
			        exist.setBrandName(brand.getBrandName());
			        exist.setUpdateDate(createBrandDate());
			       
				brandrepo.save(exist);
				return "Brand updated "+id;
				}
		return "Not updated "+id;
		// TODO Auto-generated method stub
		
	}

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
