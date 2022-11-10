package com.masai.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Client;
import com.masai.repository.ClientDao;
import com.masai.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	private ClientDao clientDao;
	@Override
	public Client addClient(Client client) {
		Client c = clientDao.save(client);
		return client;
	}

	@Override
	public Client removeClientById(Integer clientId) {
		Optional<Client> opt = clientDao.findById(clientId);
		Client client = opt.get();
		if(opt.isPresent()) {
			clientDao.deleteById(clientId);
			return client;
		}
		return null;
	}

	@Override
	public Client viewClientById(Integer clientId) {
		Optional<Client> opt = clientDao.findById(clientId);
		Client client = opt.get();
		if(opt.isPresent()) {
			return client;
		}
		return null;
	}

	@Override
	public Client updateClientById(Integer clientId, Client client) {
		Optional<Client> opt = clientDao.findById(clientId);
		if(opt.isPresent()) {
			client.setClientId(clientId);
			return clientDao.save(client);
		}
		return null;
	}

	@Override
	public List<Client> viewAllClients() {
		List<Client> client = clientDao.findAll();
		return client;
	}

}
