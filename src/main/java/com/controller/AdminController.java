package com.controller;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Admin;
import com.bean.Product;
import com.service.AdminService;
import com.service.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	ProductService productService;
	
	@PostMapping(value = "signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String singIn(@RequestBody Admin admin) {
		if(adminService.SignIn(admin))
			return "Welcome admin";
		return "Incorrect user name or password";
	}
	// ****** update required *************
	//change password for admin
//	@PutMapping(value = "changePassword", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String changePassword(@RequestBody Admin admin) {
//		if(adminService.changePassword(admin))
//			return "Password changed sucessfully";
//		else 
//			return "Password not changed";
//			
//		}	
	
	//add product
	@PostMapping(value = "addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addProduct(@RequestBody Product product) {
		if(productService.addProduct(product))
			return "Sucessfully added "+product.getProductName()+".";
		else 
			return "Invalid input or product with same id already exists";
	}
}
