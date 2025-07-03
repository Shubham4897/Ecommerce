package com.product.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.entities.CartManager;
import com.product.entities.Product;
import com.product.entities.Users;
import com.product.entities.requests.CartManagerDTO;
import com.product.repository.CartRepository;
import com.product.repository.ProductRepository;
import com.product.repository.UserRepository;

@Service
public class CartService{
	@Autowired
	private CartRepository cartrepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;

	public List<CartManager> getCartList() {
		return cartrepository.findAll();
	}
		public ResponseEntity<?> createCarts(CartManagerDTO cartDto) {
			CartManager carts=new CartManager();
			
		Optional<Product> products= productRepository.findById(cartDto.getProductId());
		Optional<Users> users=userRepository.findById(cartDto.getUserId());
		carts.setUser(users.get());
		carts.setQuantity(cartDto.getQuantity());
		carts.setProduct(products.get());
		carts.setCreatedDate(createCartDate());
		cartrepository.save(carts);
		return ResponseEntity.ok("Saved Successfully");
	}

	public ResponseEntity<?> editCart(CartManagerDTO cartDto, Long id) {
		
		Optional<CartManager> cart=cartrepository.findById(id);	
		
		Optional<Product> products= productRepository.findById(cartDto.getProductId());
		Optional<Users> users=userRepository.findById(cartDto.getUserId());

		
		if(cart.isPresent()) {
			CartManager exist=cart.get();
			exist.setProduct(products.get());
			exist.setUser(users.get());
			exist.setQuantity(cartDto.getQuantity());
			exist.setUpdatedDate(createCartDate());
			cartrepository.save(exist);
			return  ResponseEntity.ok(id+" Updated Successfully");
		}
		return ResponseEntity.ok(id+" Not Updated...Try Again!!!");
	}

	public ResponseEntity<?> deleteCartById(Long id) {
		if(cartrepository.existsById(id)) {
		cartrepository.deleteById(id);
		return ResponseEntity.ok(id+" Removed SuccessFully");
	}
		return ResponseEntity.badRequest().body(id+" Not Removed");
		}
	public String createCartDate() {
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
