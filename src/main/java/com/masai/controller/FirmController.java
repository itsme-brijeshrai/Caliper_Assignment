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
import com.masai.entity.Firm;
import com.masai.service.FirmService;

@RestController
@RequestMapping("/Firms")
public class FirmController {
	@Autowired
	private FirmService firmService;
	
	@PostMapping("/addFirm")
	public ResponseEntity<String> addFirmHandler(@RequestBody Firm firm){
		Firm c = firmService.addFirm(firm);
		return new ResponseEntity<String>("Firm added"+c,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> removeFirmHandler(@PathVariable("Id")Integer Id, @RequestBody Firm firm){
		Firm c = firmService.removeFirmById(Id);
		if(Id==null) {
			throw new NullPointerException();
		}else {
		return new ResponseEntity<String>("Delete Success"+c,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/get/{Id}")
	public ResponseEntity<String> viewFirmHandler(@PathVariable("Id")Integer Id){
		Firm firm = firmService.viewFirmById(Id);
		if(Id==null) {
			throw new NullPointerException();
		}else {
		return new ResponseEntity<String>(""+firm,HttpStatus.ACCEPTED);
		}
	}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<String> updateFirmHandler(@PathVariable("Id")Integer Id, @RequestBody Firm firm){
		Firm c = firmService.updateFirmById(Id, firm);
		if(Id==null) {
			throw new NullPointerException();
		}else {
		return new ResponseEntity<String>("Update success"+c,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<String> viewAllClientHandler (@RequestBody Firm firm){
		List<Firm> c = firmService.viewAllFirms();
		return new ResponseEntity<String>(""+c,HttpStatus.ACCEPTED);
	}

}
