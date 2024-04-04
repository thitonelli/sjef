package com.example.sjef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.sjef.entities.Category;
import com.example.sjef.repositories.CategoryRepository;
import com.example.sjef.services.exceptions.DatabaseException;
import com.example.sjef.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Category insert(Category category) {
		return categoryRepository.save(category);
	}
	
	public void delete(Long id) {
		try {
			categoryRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Category update(Category category) {
		try {
			Category newCategory = findById(category.getId());
			updateData(newCategory, category);
			return categoryRepository.save(newCategory);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(category.getId());
		}
	}

	private void updateData(Category newCategory, Category category) {
		newCategory.setName(category.getName());
	}
	
	
	
	
}
