package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.dao.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public boolean signUp(User user) {
		User saveUser = userRepository.save(user);
		if(saveUser.getEmail().isBlank())
			return false;
		return true;
		
	}
	
	public User signIn(String email, String password) {
		return userRepository.signIn(email,password);
	}
	
	public List<User> getAllUsers(){
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}
}
