package com.java.tech.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.tech.entity.User;
import com.java.tech.exception.ResourceNotFoundException;
import com.java.tech.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public User saveUser(User user) {
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}
	
	@Override
	public User findUserByUserId(String userId) {
		return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Given UserId Not Found "+userId));
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
