package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
}
