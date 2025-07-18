package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entities.CartManager;
import com.product.entities.requests.CartManagerDTO;
import com.product.service.CartService;

@RestController
@RequestMapping("/api/cart-manager")
public class CartController {
	@Autowired
	private CartService cartservice;
	
	@GetMapping
	public List<CartManager> getList(){
		return cartservice.getCartList();
	}
	@PostMapping
	public ResponseEntity<?> createCart(@RequestBody CartManagerDTO cartDto){
		return cartservice.createCarts(cartDto);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCart(@RequestBody CartManagerDTO cartDto, @PathVariable Long id){
		return cartservice.editCart(cartDto,id);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeCart(@PathVariable Long id){
		return cartservice.deleteCartById(id);
	}
	

}
