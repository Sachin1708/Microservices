package com.java.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.tech.entity.User;
import com.java.tech.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {		
		User userData=userService.saveUser(user);		
		return ResponseEntity.status(HttpStatus.CREATED).body(userData);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> findUserByUserId(@PathVariable String userId) {
		
		User userData= userService.findUserByUserId(userId);
		return ResponseEntity.ok(userData);
	}
	
	@GetMapping("/findAllUsers")
	public ResponseEntity<List<User>> findAllUsers(){
		
		List<User> userDataList= userService.getAllUser();
		return ResponseEntity.ok(userDataList);
	}
	
}
