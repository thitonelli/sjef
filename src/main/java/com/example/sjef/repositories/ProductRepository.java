package com.example.sjef.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sjef.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
