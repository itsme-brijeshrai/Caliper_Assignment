package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.entity.Product;

@Service
public interface ProductService {
	public Product addProduct(Product product);
	public Product removeProduct(Integer Id);
	public Product updateProduct(Integer Id, Product product);
	public Product viewProduct(Integer Id);
}
