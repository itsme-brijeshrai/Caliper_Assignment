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

import com.masai.entity.Address;
import com.masai.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/addClient")
	public ResponseEntity<String> addAddressHandler(@RequestBody Address address){
		Address c = addressService.addAddress(address);
		return new ResponseEntity<String>("address added"+c,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> removeClientHandler(@PathVariable("Id")Integer Id, @RequestBody Address address){
		Address c = addressService.removeAddressById(Id);
		if(Id==null) {
			throw new NullPointerException();
		}else {
		return new ResponseEntity<String>("Delete Success"+c,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/get/{Id}")
	public ResponseEntity<String> viewClientHandler(@PathVariable("Id")Integer Id){
		Address c = addressService.viewAddressById(Id);
		if(Id==null) {
			throw new NullPointerException();
		}else {
		return new ResponseEntity<String>(""+c,HttpStatus.ACCEPTED);
		}
	}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<String> updateClientHandler(@PathVariable("Id")Integer Id, @RequestBody Address address){
		Address c = addressService.updateAddressById(Id, address);
		if(Id==null) {
			throw new NullPointerException();
		}else {
		return new ResponseEntity<String>("Update success"+c,HttpStatus.ACCEPTED);
		}
	}
	

}
