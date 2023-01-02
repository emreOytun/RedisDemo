package com.emreoytun.microservices.redisdemo.repository;

import java.util.List;

import com.emreoytun.microservices.redisdemo.entity.User;

public interface UserDaoI {

	boolean saveUser(User user);

	List<User> fetchUsers();

	boolean deleteUser(Long id);

	User getUserById(Long id);

}
