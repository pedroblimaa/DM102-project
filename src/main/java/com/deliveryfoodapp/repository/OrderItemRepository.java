package com.deliveryfoodapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryfoodapp.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
}