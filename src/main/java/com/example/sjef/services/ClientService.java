package com.example.sjef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sjef.entities.Client;
import com.example.sjef.entities.dto.ClientDTO;
import com.example.sjef.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client fromDTO(ClientDTO clientDTO) {
		return new Client(clientDTO.getId(), clientDTO.getFirstName(), clientDTO.getLastName(), clientDTO.getEmail());
	}
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client findById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.get();
	}
	
	public Client insert(Client obj) {
		return clientRepository.save(obj);
	}
	
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
	
	public Client update(Client client) {
		Client newClient = findById(client.getId());
		updateData(newClient, client);
		return clientRepository.save(newClient);
	}

	private void updateData(Client entity, Client obj) {
		entity.setFirstName(obj.getFirstName());
		entity.setEmail(obj.getEmail());
	}
	
	
	
	
}
