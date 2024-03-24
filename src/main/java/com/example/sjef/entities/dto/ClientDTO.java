package com.example.sjef.entities.dto;

import java.io.Serializable;

import com.example.sjef.entities.Client;

public class ClientDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
	public ClientDTO() {
		
	}
	
	public ClientDTO(Client client) {
		id = client.getId();
		firstName = client.getFirstName();
		lastName = client.getLastName();
		email = client.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
