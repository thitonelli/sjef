package com.example.sjef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.sjef.entities.User;
import com.example.sjef.entities.dto.UserDTO;
import com.example.sjef.repositories.UserRepository;
import com.example.sjef.services.exceptions.DatabaseException;
import com.example.sjef.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName() , userDTO.getEmail());
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(User user) {
		try {
			User newUser = findById(user.getId());
			updateData(newUser, user);
			return userRepository.save(newUser);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(user.getId());
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
	}
	
	
	
	
}
