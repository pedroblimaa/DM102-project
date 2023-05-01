package com.deliveryfoodapp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryfoodapp.model.Category;
import com.deliveryfoodapp.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {
  List<Restaurant> findAll();

  Restaurant findById(Long id);

  List<Restaurant> findByCategory(Category category);
}