package com.masai.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Product;
import com.masai.repository.ProductDao;
import com.masai.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	@Override
	public Product addProduct(Product product) {
		Product p = productDao.save(product);
		return p;
	}

	@Override
	public Product removeProduct(Integer Id) {
		Optional<Product> opt = productDao.findById(Id);
		Product p = opt.get();
		productDao.deleteById(Id);
		return p;
	}

	@Override
	public Product updateProduct(Integer Id, Product product) {
		Optional<Product> opt = productDao.findById(Id);
		Product p = opt.get();
		product.setProductId(Id);
		return productDao.save(product);
	}

	@Override
	public Product viewProduct(Integer Id) {
		Optional<Product> opt = productDao.findById(Id);
		Product p = opt.get();
		return p;
	}

}
