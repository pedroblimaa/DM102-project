package com.deliveryfoodapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryfoodapp.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, UUID> {
	Driver findById(Long id);
}