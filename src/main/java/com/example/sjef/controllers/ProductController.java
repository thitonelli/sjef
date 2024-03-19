package com.example.sjef.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sjef.entities.Product;
import com.example.sjef.repositories.ProductRepository;


@RestController
@RequestMapping(value="/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = productRepository.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<Product>> findById(@PathVariable Long id){
		Optional<Product> product = productRepository.findById(id);
		return ResponseEntity.ok().body(product);
	}
	
}
