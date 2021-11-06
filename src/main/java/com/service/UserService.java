package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.NonUniqueSessionRepositoryException;
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
	
	public User signIn(User user) {
		User isUser = userRepository.signIn(user.getEmail(),user.getPassword());
		if(isUser == null)
			return null;
		return isUser;
	}
	
	public List<User> getAllUsers(){
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}
	
	public List<User> searchUserByName(String name){
		List<User> searchUsers = userRepository.searchUser(name);
		if(searchUsers.size() > 0)
			return searchUsers;
		return null;
	}
}
