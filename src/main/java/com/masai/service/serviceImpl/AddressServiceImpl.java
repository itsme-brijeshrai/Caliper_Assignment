package com.masai.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Address;
import com.masai.repository.AddressDao;
import com.masai.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressDao addressDao;
	@Override
	public Address addAddress(Address address) {
		Address add = addressDao.save(address);
		return add;
	}

	@Override
	public Address removeAddressById(Integer addressId) {
		Optional<Address> address = addressDao.findById(addressId);
		Address add = address.get();
		addressDao.delete(add);
		return add;
	}

	@Override
	public Address viewAddressById(Integer addressId) {
		Optional<Address> opt = addressDao.findById(addressId);
		Address a = opt.get();
		return a;
	}

	@Override
	public Address updateAddressById(Integer addressId, Address address) {
		Optional<Address> opt = addressDao.findById(addressId);
		Address a= opt.get();
		address.setAddressId(addressId);
		return addressDao.save(address);
	}

}
