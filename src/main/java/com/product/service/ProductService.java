package com.product.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entities.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	public List<Product> getAllProducts() {
		return repository.findAll() ;
	}

	public Product CreateProduct(Product product) {
		
		product.setCreatedDate(createProductDate());
		
		return repository.save(product);
	}

	public Optional<Product> productById(Long id) {
		return repository.findById(id);
	}

	public String updateProdById(Long id, Product product) {
		Optional<Product> prods=repository.findById(id);
		if(prods.isPresent()) {
		Product exist	=prods.get();
		exist.setProductName(product.getProductName());
		exist.setProductPrice(product.getProductPrice());
		exist.setDiscountedPrice(product.getDiscountedPrice());
		exist.setUpdatedDate(createProductDate());

		 repository.save(exist);
		 return "updated"+" "+id+" succcesfully";
		}
		return "Not Added"+" "+id;
		
	}

	public String deleteProdById(Long id) {
		repository.deleteById(id);
		return "Deleted"+" "+id+" Succesfully";
	}

	public String createProductDate() {
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
