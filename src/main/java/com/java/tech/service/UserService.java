package com.java.tech.service;

import java.util.List;

import com.java.tech.entity.User;

public interface UserService {
	
	//create user
	User saveUser(User user);
	
	//get single user of given userid
	User findUserByUserId(String userId);
	
	//get all users
	List<User> getAllUser();

}
