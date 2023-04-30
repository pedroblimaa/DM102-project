package com.deliveryfoodapp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryfoodapp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
  List<Customer> findAll();

  Customer findById(Long id);
}