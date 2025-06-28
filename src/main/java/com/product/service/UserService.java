package com.product.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.entities.Users;
import com.product.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepository;

	public List<Users> getUserList() {
		return userrepository.findAll();
	}

	public ResponseEntity<?> createUser(Users user) {
		user.setCreatedDate(getCurrentDateTime());
		userrepository.save(user);
		return ResponseEntity.ok("User Saved");
	}

	public Optional<Users> getUserById(Long id) {
		return userrepository.findById(id);
		
	}

	public ResponseEntity<?> updateUserById(Users users, Long id) {
		Optional<Users> user=userrepository.findById(id);
		if(user.isPresent()) {
			Users exist=user.get();
			exist.setUserName(users.getUserName());
			exist.setPassword(users.getPassword());
			exist.setEmail(users.getEmail());
			exist.setUpdatedDate(getCurrentDateTime());
			userrepository.save(exist);
			return ResponseEntity.ok(id+" Updated Successfully");
		}
		return ResponseEntity.badRequest().body(id+ " Not Updated "+" try again...!!!");
	 }


	public ResponseEntity<?> deleteUserById(Long id) {
		if(userrepository.existsById(id)) {
			userrepository.deleteById(id);
			return ResponseEntity.ok(id+" deleted Successfully");
		}
		return ResponseEntity.badRequest().body(id+" not deleted "+" try again...!!! ");
	}
	
	 private String getCurrentDateTime() {
	        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	    }

	 
}
