package com.example.sjef.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sjef.entities.Client;
import com.example.sjef.repositories.ClientRepository;


@RestController
@RequestMapping(value="/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = clientRepository.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<Client>> findById(@PathVariable Long id){
		Optional<Client> client = clientRepository.findById(id);
		return ResponseEntity.ok().body(client);
	}
	
}
