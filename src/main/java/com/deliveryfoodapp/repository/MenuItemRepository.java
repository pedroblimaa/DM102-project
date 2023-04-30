package com.deliveryfoodapp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryfoodapp.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, UUID> {
  List<MenuItem> findAll();

  MenuItem findById(Long id);
}