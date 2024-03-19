package com.example.sjef.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sjef.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
