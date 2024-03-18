package com.example.sjef.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.sjef.entities.Client;
import com.example.sjef.entities.Order;
import com.example.sjef.entities.enums.OrderStatus;
import com.example.sjef.repositories.ClientRepository;
import com.example.sjef.repositories.OrderRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Maria", "Joana", "maria@gmail.com");
		Client c2 = new Client(null, "Joana", "Maria", "joana@gmail.com");
		
		clientRepository.saveAll(Arrays.asList(c1, c2));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.SHIPPED, c1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, c2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, c1);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	

}
