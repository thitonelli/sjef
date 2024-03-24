package com.example.sjef.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sjef.entities.User;
import com.example.sjef.repositories.UserRepository;


@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userRepository.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
		Optional<User> user = userRepository.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
}
