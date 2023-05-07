package com.deliveryfoodapp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deliveryfoodapp.model.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {
	List<Order> findAllByStatus(String status);
	
	Order findById(Long id);
}