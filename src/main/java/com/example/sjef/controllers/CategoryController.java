package com.example.sjef.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sjef.entities.Category;
import com.example.sjef.repositories.CategoryRepository;


@RestController
@RequestMapping(value="/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = categoryRepository.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
		Optional<Category> category = categoryRepository.findById(id);
		return ResponseEntity.ok().body(category);
	}
	
}
