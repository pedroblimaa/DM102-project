package com.deliveryfoodapp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryfoodapp.model.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
  List<Category> findAll();

  Category findById(Long id);
}