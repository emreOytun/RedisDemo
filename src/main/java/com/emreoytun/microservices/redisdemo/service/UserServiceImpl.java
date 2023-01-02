package com.emreoytun.microservices.redisdemo.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreoytun.microservices.redisdemo.entity.User;
import com.emreoytun.microservices.redisdemo.repository.UserDaoI;

@Service
public class UserServiceImpl implements UserServiceI {
	
	@Autowired
	private UserDaoI userDao;
	
	@Override
	public boolean saveUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	public List<User> fetchUsers() {
		return userDao.fetchUsers();
	}

	@Override
	public boolean deleteUser(Long id) {
		return userDao.deleteUser(id);
	}

	@Override
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}

}
