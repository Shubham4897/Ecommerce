package com.product.controller;

import java.util.List;
import java.util.Optional;

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

import com.product.entities.Users;
import com.product.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/all")
	public List<Users>  getUserList(){
		return userservice.getUserList();
	}
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody Users user){
		return userservice.createUser(user);
	}
	@GetMapping("/{id}")
	public Optional<Users> userById(@PathVariable Long id){
		return userservice.getUserById(id);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> editUserbyId(@RequestBody Users user,@PathVariable Long id){
		return userservice.updateUserById(user,id);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> removeUser(@PathVariable Long id){
		return userservice.deleteUserById(id);
	}
	
}
