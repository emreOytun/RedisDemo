package com.emreoytun.microservices.redisdemo.controllers;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emreoytun.microservices.redisdemo.entity.User;
import com.emreoytun.microservices.redisdemo.service.UserServiceI;


@RestController
public class UserController {

	@Autowired
	private UserServiceI userService;
	
	@PostMapping("/users/add")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		boolean result = userService.saveUser(user);
		if (result) {
			return ResponseEntity.ok("User created successfully.");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/users/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		boolean result = userService.deleteUser(id);
		if (result) {
			return ResponseEntity.ok("User deleted successfully.");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/users/get")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.fetchUsers();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("users/get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	
}
