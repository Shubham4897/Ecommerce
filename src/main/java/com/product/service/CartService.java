package com.product.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.product.entities.CartManager;
import com.product.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartrepository;

	public List<CartManager> getCartList() {
		return cartrepository.findAll();
	}

	public ResponseEntity<?> createCarts(CartManager cartmanager) {
		cartmanager.setCreatedDate(createCartDate());
		cartrepository.save(cartmanager);
		return ResponseEntity.ok("Saved Successfully");
	}

	public ResponseEntity<?> editCart(CartManager cartmanager, Long id) {
		Optional<CartManager> cart=cartrepository.findById(id);		
		if(cart.isPresent()) {
			CartManager exist=cart.get();
			exist.setCartName(cartmanager.getCartName());
			exist.setQuantity(cartmanager.getQuantity());
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
