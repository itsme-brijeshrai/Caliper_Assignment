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

import com.masai.entity.Client;
import com.masai.exception.InvalidId;
import com.masai.service.ClientService;
@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/addClient")
	public ResponseEntity<String> addClientHandler(@RequestBody Client client){
		Client c = clientService.addClient(client);
		return new ResponseEntity<String>("Client added"+c,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> removeClientHandler(@PathVariable("Id")Integer Id, @RequestBody Client client){
		Client c = clientService.removeClientById(Id);
		if(Id==null) {
			throw new NullPointerException();
		}else {
		return new ResponseEntity<String>("Delete Success"+c,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/get/{Id}")
	public ResponseEntity<String> viewClientHandler(@PathVariable("Id")Integer Id){
		Client client = clientService.viewClientById(Id);
		if(Id==null) {
			throw new InvalidId();
		}else {
		return new ResponseEntity<String>(""+client,HttpStatus.ACCEPTED);
	}
	}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<String> updateClientHandler(@PathVariable("Id")Integer Id, @RequestBody Client client){
		Client c = clientService.updateClientById(Id, client);
		if(Id==null) {
			throw new InvalidId();
		}else {
		return new ResponseEntity<String>("Update success"+c,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<String> viewAllClientHandler (@RequestBody Client client){
		List<Client> c = clientService.viewAllClients();
		return new ResponseEntity<String>(""+c,HttpStatus.ACCEPTED);
	}
}
