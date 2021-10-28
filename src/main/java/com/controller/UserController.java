package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.User;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	//SignUp for user
	@PostMapping(value = "signUp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody User user) {
		if(userService.signUp(user))
			return "Welcome "+user.getName()+" you have sucesfully SignUp";
		else 
			return "User with "+user.getEmail()+" already exists";
	}
	
	//SignIn
	@PutMapping(value = "signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody String email,@RequestBody String password) {
		User user = userService.signIn(email, password);
		if(user != null)
			return "Welcome "+user.getName();
		else 
			return "Invalid email or password. Please try again!";
	}
	
	//Get all users for admin
	@GetMapping(value = "allUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
}
