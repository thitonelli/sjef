package com.example.sjef.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sjef.entities.Client;

@RestController
@RequestMapping(value="clients")
public class ClientController {
	
	@GetMapping
	public ResponseEntity<Client> findAll(){
		Client cli = new Client(1L, "Thiago", "Fabris", "thi@gmail.com");
		return ResponseEntity.ok().body(cli);
	}
}
