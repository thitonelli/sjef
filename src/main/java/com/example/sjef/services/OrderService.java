package com.example.sjef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sjef.entities.Order;
import com.example.sjef.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.get();
	}
	
	public Order insert(Order order) {
		return orderRepository.save(order);
	}
	
	public void delete(Long id) {
		orderRepository.deleteById(id);
	}
	
	public Order update(Order order) {
		Order newOrder = findById(order.getId());
		updateData(newOrder, order);
		return orderRepository.save(newOrder);
	}

	private void updateData(Order newOrder, Order order) {
		newOrder.setMoment(order.getMoment());
		newOrder.setOrderStatus(order.getOrderStatus());
	}
	
	
	
	
}
