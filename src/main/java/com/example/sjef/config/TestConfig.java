package com.example.sjef.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.sjef.entities.Category;
import com.example.sjef.entities.Client;
import com.example.sjef.entities.Order;
import com.example.sjef.entities.Product;
import com.example.sjef.entities.enums.OrderStatus;
import com.example.sjef.repositories.CategoryRepository;
import com.example.sjef.repositories.ClientRepository;
import com.example.sjef.repositories.OrderRepository;
import com.example.sjef.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Maria", "Joana", "maria@gmail.com");
		Client c2 = new Client(null, "Joana", "Maria", "joana@gmail.com");
		
		clientRepository.saveAll(Arrays.asList(c1, c2));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.SHIPPED, c1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, c2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, c1);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product prod1 = new Product(null, "Phone", 1200.00);
		Product prod2 = new Product(null, "Harry Potter", 30.00);
		Product prod3 = new Product(null, "Notebook", 2000.00);
		
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		prod1.getCategories().add(cat1);
		prod2.getCategories().add(cat2);
		prod3.getCategories().add(cat3);
		
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
	}
	

}
