package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.entity.Address;


@Service
public interface AddressService {
	
	public Address addAddress(Address address);
	public Address removeAddressById(Integer addressId);
	public Address viewAddressById(Integer addressId);
	public Address updateAddressById(Integer addressId, Address address);

}
