package com.deliveryfoodapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliveryfoodapp.model.Customer;
import com.deliveryfoodapp.model.Restaurant;
import com.deliveryfoodapp.model.Review;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
  Review findByCustomerAndRestaurant(Customer customer, Restaurant restaurant);

  Iterable<Review> findByRestaurant(Restaurant restaurant);
}
