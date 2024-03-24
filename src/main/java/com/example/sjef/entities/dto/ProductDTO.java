package com.example.sjef.entities.dto;

import java.io.Serializable;

import com.example.sjef.entities.Product;

public class ProductDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double price;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(Product product) {
		id = product.getId();
		name = product.getName();
		price = product.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
