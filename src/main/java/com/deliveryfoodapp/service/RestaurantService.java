package com.deliveryfoodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliveryfoodapp.model.Restaurant;
import com.deliveryfoodapp.repository.RestaurantRepository;

@Service
public class RestaurantService {

  @Autowired
  private RestaurantRepository restaurantRepo;

  public Restaurant getRestaurantById(Long id) {
    Restaurant restaurant = restaurantRepo.findById(id);
    if (restaurant == null) {
      throw new IllegalArgumentException("Restaurant does not exist.");
    }

    return restaurant;
  }
}
