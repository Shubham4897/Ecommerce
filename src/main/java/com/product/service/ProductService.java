package com.product.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.entities.Brand;
import com.product.entities.Category;
import com.product.entities.Product;
import com.product.entities.SubCategory;
import com.product.entities.requests.RequestProduct;
import com.product.repository.BrandRepository;
import com.product.repository.CategoryRepo;
import com.product.repository.ProductRepository;
import com.product.repository.SubRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	@Autowired
	private BrandRepository brandRepo;	
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private SubRepository subRepo;
	
	//Get List
	public List<Product> getAllProducts() {
		return repository.findAll() ;
	}

	public Product CreateProduct(RequestProduct reqproduct) {	
	Product product=new Product();
	Optional<Brand> brand=brandRepo.findById(reqproduct.getBrandId());
	Optional<Category> category=categoryRepo.findById(reqproduct.getCategoryId());
	Optional<SubCategory> subCategory=subRepo.findById(reqproduct.getSubId());

	product.setSubcategory(subCategory.get());
	product.setCategory(category.get());
	product.setBrand(brand.get());
	product.setProductName(reqproduct.getProductName());
	product.setDiscountedPrice(calculateDiscountedPrice(reqproduct.getProductPrice(), reqproduct.discountPercent));
	product.setProductPrice(reqproduct.getProductPrice());
	product.setColor(reqproduct.getColor());
	product.setDimensions(reqproduct.getDimensions());
	product.setMaterial(reqproduct.getMaterial());
	product.setModel(reqproduct.getModel());
	product.setSku(reqproduct.getSku());
	product.setStockQuantity(reqproduct.getStockQuantity());
	product.setWeight(reqproduct.getWeight());
	product.setDescription(reqproduct.getDescription());
	product.setImageUrl(reqproduct.getImageUrl()); // Added imageUrl

	product.setCreatedDate(createProductDate());
		return repository.save(product);
	}

	public String updateProdById(Long id, RequestProduct reqproduct) {
		Optional<Product> prods=repository.findById(id);
		Optional<Brand> brand=brandRepo.findById(reqproduct.getBrandId());
		Optional<SubCategory> subcategory=subRepo.findById(reqproduct.getSubId());
		Optional<Category> category=categoryRepo.findById(reqproduct.getCategoryId());
		
		if(prods.isPresent()) {
		Product exist=prods.get();
		exist.setSubcategory(subcategory.get());
		exist.setBrand(brand.get());
		exist.setCategory(category.get());
		exist.setProductName(reqproduct.getProductName());
		exist.setProductPrice(reqproduct.getProductPrice());
		exist.setDiscountedPrice(reqproduct.getDiscountedPrice());
		exist.setImageUrl(reqproduct.getImageUrl()); // Added imageUrl
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

	
	 public  double calculateDiscountedPrice(double originalPrice, double discountPercentage) {
	        
	        if (originalPrice < 0) {
	            throw new IllegalArgumentException("Original price cannot be negative.");
	        }
	        
	        if (discountPercentage < 0 || discountPercentage > 100) {
	            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
	        }

	        
	        double discountAmount = (originalPrice * discountPercentage) / 100;

	        double discountedPrice = originalPrice - discountAmount;

	        return discountedPrice;
	    }

}