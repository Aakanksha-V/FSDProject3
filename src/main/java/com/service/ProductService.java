package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public boolean addProduct(Product product) {
		Product p = productRepository.save(product);
		if(p.getProductName().isBlank())
			return false;
		return true;
	}
}
