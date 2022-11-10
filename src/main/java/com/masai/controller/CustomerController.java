package com.masai.controller;

import java.util.List;

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

import com.masai.entity.Customer;
import com.masai.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addClient")
	public ResponseEntity<String> addCustomerHandler(@RequestBody Customer customer){
		Customer c = customerService.addCustomer(customer);
		return new ResponseEntity<String>("Customer added"+c,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> removeClientHandler(@PathVariable("Id")Integer Id, @RequestBody Customer customer){
		Customer c = customerService.removeCustomerById(Id);
		if(Id==null) {
			throw new NullPointerException();
		}else {
		return new ResponseEntity<String>("Delete Success"+c,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/get/{Id}")
	public ResponseEntity<String> viewClientHandler(@PathVariable("Id")Integer Id){
		Customer c = customerService.viewCustomerById(Id);
		if(Id==null) {
			throw new NullPointerException();
		}else {
		return new ResponseEntity<String>(""+c,HttpStatus.ACCEPTED);
		}
	}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<String> updateClientHandler(@PathVariable("Id")Integer Id, @RequestBody Customer customer){
		Customer c = customerService.updateCustomerById(Id, customer);
		if(Id==null) {
			throw new NullPointerException();
		}else {
		return new ResponseEntity<String>("Update success"+c,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<String> viewAllClientHandler (@RequestBody Customer customer){
		List<Customer> c = customerService.viewAllCustomer();
		return new ResponseEntity<String>(""+c,HttpStatus.ACCEPTED);
	}

}
