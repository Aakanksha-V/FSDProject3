package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Admin;
import com.dao.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	public boolean SignIn(Admin admin) {
		System.out.println("Inside admin sign service");
		Admin isAdmin = adminRepository.findAdmin(admin.getEmail());
		if(isAdmin.getPass().equals(admin.getPass()))
			return true;
		return false;
	}
	
	public boolean changePassword(Admin admin) {
		if (adminRepository.changePasswrd(admin.getEmail(),admin.getPass()) == 1) 
			return true;
		return false;
	}
}
