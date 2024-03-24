package com.example.sjef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sjef.entities.Product;
import com.example.sjef.entities.dto.ProductDTO;
import com.example.sjef.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product fromDTO(ProductDTO productDTO) {
		return new Product(productDTO.getId(), productDTO.getName(), productDTO.getPrice());
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
	
	public Product insert(Product product) {
		return productRepository.save(product);
	}
	
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	
	public Product update(Product product) {
		Product newProduct = findById(product.getId());
		updateData(newProduct, product);
		return productRepository.save(newProduct);
	}

	private void updateData(Product newProduct, Product product) {
		newProduct.setName(product.getName());
		newProduct.setPrice(product.getPrice());
	}
}
