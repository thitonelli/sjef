package com.example.sjef.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.sjef.entities.Client;
import com.example.sjef.entities.dto.ClientDTO;
import com.example.sjef.services.ClientService;



@RestController
@RequestMapping(value="/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll(){
		List<Client> list = clientService.findAll(); 
		List<ClientDTO> listDto = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
		Client clientDto = clientService.findById(id);
		return ResponseEntity.ok().body(new ClientDTO(clientDto));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ClientDTO clientDTO){
		Client client = clientService.fromDTO(clientDTO);
		client = clientService.insert(client);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody ClientDTO clientDTO, @PathVariable Long id){
		Client client = clientService.fromDTO(clientDTO);
		client.setId(id);
		client = clientService.insert(client);
		return ResponseEntity.noContent().build();
	}
	
	
}
