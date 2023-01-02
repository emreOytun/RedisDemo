package com.emreoytun.microservices.redisdemo.repository;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.emreoytun.microservices.redisdemo.entity.User;

@Repository
public class UserDaoImpl implements UserDaoI {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	private static final String KEY = "USER";
	
	@Override
	public boolean saveUser(User user) {
		try {
			redisTemplate.opsForHash().put(KEY, Long.toString(user.getId()), user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> fetchUsers() {
		List<Object> result = redisTemplate.opsForHash().values(KEY);
		List<User> users = new ArrayList<>();
		
		for (Object o : result) {
			if (o.getClass().equals(User.class)) {
				users.add((User) o); 
			}
		}
		
		return users;
	}

	@Override
	public boolean deleteUser(Long id) {
		try {
			redisTemplate.opsForHash().delete(KEY, id.toString());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserById(Long id) {
		return (User) redisTemplate.opsForHash().get(KEY, id.toString());
	}

}
