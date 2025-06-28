package com.product.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.entities.SubCategory;
import com.product.repository.SubRepository;

@Service
public class SubService {

   
	@Autowired
	private SubRepository reposit;
 
	public List<SubCategory> getSubAll() {
		return reposit.findAll();
	
	}
	public SubCategory CreateSubCategory(SubCategory subcategory) {
		
		subcategory.setCreateDate(createSubDate());
		return reposit.save(subcategory);
			
	}

	public String UpdateSub(Long id, SubCategory subcategory) {
				Optional<SubCategory> ob=reposit.findById(id);
				if(ob.isPresent()) {
						SubCategory exists=ob.get();
						exists.setSubName(subcategory.getSubName());
						exists.setUpdateDate(createSubDate());
						reposit.save(exists);
						return "Added";
				}else {
						return "Not added";
				}
	}
	public String deleteSub(Long id) {
		
		reposit.deleteById(id);	
	
		return id+" deleted";
	}
	
	public String createSubDate() {
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
