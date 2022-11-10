package com.masai.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Customer;
import com.masai.repository.CustomerDao;
import com.masai.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;
	@Override
	public Customer addCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer removeCustomerById(Integer customerId) {
		Optional<Customer> opt = customerDao.findById(customerId);
		Customer customer = opt.get();
		if(opt.isPresent()) {
			customerDao.deleteById(customerId);
		}
		return customer;
	}

	@Override
	public Customer viewCustomerById(Integer customerId) {
		Optional<Customer> opt = customerDao.findById(customerId);
		Customer customer = opt.get();
		if(opt.isPresent()) {
			return customer;
		}
		return null;
	}

	@Override
	public Customer updateCustomerById(Integer customerId, Customer customer) {
		Optional<Customer> opt = customerDao.findById(customerId);
		if(opt.isPresent()) {
			customer.setCustomerId(customerId);
			return customerDao.save(customer);
		}
		return null;
	}

	@Override
	public List<Customer> viewAllCustomer() {
		List<Customer> customerList = customerDao.findAll();
		return customerList;
	}

}
