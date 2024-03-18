package com.example.sjef.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.sjef.entities.Client;
import com.example.sjef.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception {
		Client u1 = new Client(null, "Maria", "Joana", "maria@gmail.com");
		Client u2 = new Client(null, "Joana", "Maria", "joana@gmail.com");
		
		clientRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	

}
