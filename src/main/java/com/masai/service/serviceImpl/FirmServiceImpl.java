package com.masai.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Firm;
import com.masai.repository.FirmDao;
import com.masai.service.FirmService;
@Service
public class FirmServiceImpl implements FirmService{
	@Autowired
	private FirmDao firmDao;

	@Override
	public Firm addFirm(Firm firm) {
		Firm f = firmDao.save(firm);
		return f;
	}

	@Override
	public Firm removeFirmById(Integer firmId) {
		Optional<Firm> opt = firmDao.findById(firmId);
		Firm firm = opt.get();
		if(opt.isPresent()) {
			firmDao.delete(firm);
		}
		return null;
	}

	@Override
	public Firm viewFirmById(Integer firmId) {
		Optional<Firm> opt = firmDao.findById(firmId);
		Firm firm = opt.get();
		return firm;
	}

	@Override
	public Firm updateFirmById(Integer firmId, Firm firm) {
		Optional<Firm> opt = firmDao.findById(firmId);
		Firm f = opt.get();
		firm.setFirmId(firmId);
		return firmDao.save(firm);
	}

	@Override
	public List<Firm> viewAllFirms() {
		List<Firm> firm = firmDao.findAll();
		return firm;
	}
	
}