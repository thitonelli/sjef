package com.example.sjef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.sjef.entities.Order;
import com.example.sjef.repositories.OrderRepository;
import com.example.sjef.services.exceptions.DatabaseException;
import com.example.sjef.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Order insert(Order order) {
		return orderRepository.save(order);
	}
	
	public void delete(Long id) {
		try {
			orderRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Order update(Order order) {
		try {
			Order newOrder = findById(order.getId());
			updateData(newOrder, order);
			return orderRepository.save(newOrder);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(order.getId());
		}
	}

	private void updateData(Order newOrder, Order order) {
		newOrder.setMoment(order.getMoment());
		newOrder.setOrderStatus(order.getOrderStatus());
	}
	
	
	
	
}
