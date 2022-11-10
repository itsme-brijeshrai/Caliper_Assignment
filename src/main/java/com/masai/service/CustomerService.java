package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.entity.Customer;


@Service
public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public Customer removeCustomerById(Integer customerId);
	public Customer viewCustomerById(Integer customerId);
	public Customer updateCustomerById(Integer customerId, Customer customer);
	public List<Customer> viewAllCustomer();
}
