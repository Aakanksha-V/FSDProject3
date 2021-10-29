package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Admin;
import com.dao.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	public boolean SignIn(Admin admin) {
		List<Admin> isAdmin = adminRepository.findAll();
		if(isAdmin.size() < 1)
			return false;
		else {
			Admin user = isAdmin.get(0);
			if(user.getEmail().equals(admin.getEmail()) &&user.getPass().equals(admin.getPass()))
				return true;
			else 
				return false;
			
		}
	}
	
	public boolean changePassword(Admin admin) {
		if (adminRepository.changePasswrd(admin.getEmail(),admin.getPass()) == 1) 
			return true;
		return false;
	}
}
