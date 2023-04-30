package com.deliveryfoodapp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryfoodapp.model.Category;
import com.deliveryfoodapp.model.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {
  List<Order> findAll();

  Order findById(Long id);

  List<Order> findByCategory(Category category);
}