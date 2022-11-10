package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.entity.Client;

@Service
public interface ClientService {
	public Client addClient(Client client);
	public Client removeClientById(Integer clientId);
	public Client viewClientById(Integer clientId);
	public Client updateClientById(Integer clientId, Client client);
	public List<Client> viewAllClients();
	
}
