package com.service;

import java.util.List;
import java.util.Optional;

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
		System.out.println(p.toString());
		if(p.getProductName().isBlank())
			return false;
		return true;
	}
	
	public Product getProductById(Integer id) {
		Optional<Product> products = productRepository.findById(id);
		if(products.isEmpty())
			return null;
		return products.get();
	}
	
	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}
	
	public boolean updateProduct(Integer id, Product product) {
		Optional<Product> getProducts = productRepository.findById(id);
		if(getProducts.isPresent()) {
			Product p = getProducts.get();
			p.setCatogery(product.getCatogery());
			p.setCompany(product.getCompany());
			p.setProductName(product.getProductName());
			p.setPrice(product.getPrice());
			Product savedProduct = productRepository.save(p);
			return true;
		}
		return false;
	}
	
	public List<Product> getAllProducts(){
		List<Product> allProducts = productRepository.findAll();
		return allProducts;
	}
}
