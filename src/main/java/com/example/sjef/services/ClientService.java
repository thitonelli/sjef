package com.example.sjef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.sjef.entities.Client;
import com.example.sjef.entities.dto.ClientDTO;
import com.example.sjef.repositories.ClientRepository;
import com.example.sjef.services.exceptions.DatabaseException;
import com.example.sjef.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return client.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Client insert(Client client) {
		return clientRepository.save(client);
	}
	
	public void delete(Long id) {
		try {
			clientRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Client update(Client client) {
		try {
			Client newClient = findById(client.getId());
			updateData(newClient, client);
			return clientRepository.save(newClient);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(client.getId());
		}
	}

	private void updateData(Client newClient, Client client) {
		newClient.setFirstName(client.getFirstName());
		newClient.setLastName(client.getLastName());
		newClient.setEmail(client.getEmail());
	}
}
