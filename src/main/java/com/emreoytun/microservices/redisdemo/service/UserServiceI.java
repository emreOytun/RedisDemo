package com.emreoytun.microservices.redisdemo.service;

import java.util.List;

import com.emreoytun.microservices.redisdemo.entity.User;

public interface UserServiceI {

	boolean saveUser(User user);

	List<User> fetchUsers();

	boolean deleteUser(Long id);

	User getUserById(Long id);
	
}
