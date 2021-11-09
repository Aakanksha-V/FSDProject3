package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Admin;
import com.bean.Product;
import com.bean.User;
import com.service.AdminService;
import com.service.ProductService;
import com.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String SingIn(@RequestBody Admin admin) {
		System.out.println("inside admin controller");
		if(adminService.SignIn(admin)) {
			System.out.println("True");
			return "Welcome admin";
		}
			
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
		System.out.println(product.toString());
		if(productService.addProduct(product))
			return "Sucessfully added "+product.getProductName()+".";
		else 
			return "Invalid input or product with same id already exists";
	}
	@GetMapping(value = "allProducts", produces = MediaType.APPLICATION_JSON_VALUE)	//working
	public List<Product> getAllProducts(){
		List<Product> allProducts = productService.getAllProducts();
		return allProducts;
	}
	
	@GetMapping(value = "getProduct/{id}", produces = MediaType.APPLICATION_JSON_VALUE)	//working
	public Product getProduct(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}
	
	//delete Product
	@DeleteMapping(value = "deleteProduct/{id}")	//working
	public String deleteProductById(@PathVariable("id") Integer id) {
		productService.deleteById(id);
		return "Deleted product sucessfully";
	}
	
	//update product by id
	@PutMapping(value = "updateProduct/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProductById(@PathVariable("id") Integer id, @RequestBody Product product) {
		if(productService.updateProduct(id, product)) {
			return "Product with id: "+id+" updated sucessfully";
		}
		return "Not able to update the product successfully";
	}
	
	@GetMapping("getUser/{name}")
	public String getUserByName(@PathVariable("name") String name){
		List<User> searchUser = userService.searchUserByName(name);
		if(searchUser.size()>0)
			return "User "+searchUser.get(0).getName()+" found!";
		else
			return "User Not found";
	}
}
