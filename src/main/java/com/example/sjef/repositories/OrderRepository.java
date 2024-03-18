package com.example.sjef.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sjef.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
