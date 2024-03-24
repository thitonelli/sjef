package com.example.sjef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sjef.entities.Category;
import com.example.sjef.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository CategoryRepository;
	
	public List<Category> findAll() {
		return CategoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> Category = CategoryRepository.findById(id);
		return Category.get();
	}
	
	public Category insert(Category category) {
		return CategoryRepository.save(category);
	}
	
	public void delete(Long id) {
		CategoryRepository.deleteById(id);
	}
	
	public Category update(Category Category) {
		Category newCategory = findById(Category.getId());
		updateData(newCategory, Category);
		return CategoryRepository.save(newCategory);
	}

	private void updateData(Category newCategory, Category category) {
		newCategory.setName(category.getName());
	}
	
	
	
	
}
