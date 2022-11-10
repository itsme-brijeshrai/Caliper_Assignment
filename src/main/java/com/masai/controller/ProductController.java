package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Product;
import com.masai.exception.InvalidId;
import com.masai.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProductHandler(@RequestBody Product product){
		Product c = productService.addProduct(product);
		return new ResponseEntity<String>("product added"+c,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> removeProductHandler(@PathVariable("Id")Integer Id){
		Product c = productService.removeProduct(Id);
		if(Id==null) {
			throw new NullPointerException();
		}else {
		return new ResponseEntity<String>("Delete Success"+c,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/get/{Id}")
	public ResponseEntity<String> viewProductHandler(@PathVariable("Id")Integer Id){
		Product product = productService.viewProduct(Id);
		if(Id==null) {
			throw new InvalidId();
		}else {
		return new ResponseEntity<String>(""+product,HttpStatus.ACCEPTED);
	}
	}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<String> updateProductHandler(@PathVariable("Id")Integer Id, @RequestBody Product product){
		Product p = productService.updateProduct(Id, product);
		if(Id==null) {
			throw new InvalidId();
		}else {
		return new ResponseEntity<String>("Update success"+p,HttpStatus.ACCEPTED);
		}
	}
}
