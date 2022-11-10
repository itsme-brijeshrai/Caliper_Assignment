package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.masai.entity.Firm;

@Service
public interface FirmService {
	
	public Firm addFirm(Firm firm);
	public Firm removeFirmById(Integer firmId);
	public Firm viewFirmById(Integer firmId);
	public Firm updateFirmById(Integer firmId, Firm firm);
	public List<Firm> viewAllFirms();
	
}
