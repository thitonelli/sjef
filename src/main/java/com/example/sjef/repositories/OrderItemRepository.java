package com.example.sjef.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sjef.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
