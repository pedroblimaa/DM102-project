package com.deliveryfoodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliveryfoodapp.model.Restaurant;
import com.deliveryfoodapp.model.Review;
import com.deliveryfoodapp.repository.ReviewRepository;

@Service
public class ReviewService {

  @Autowired
  private ReviewRepository reviewRepo;

  public String getAverageRatingByRestaurant(Restaurant restaurant) {
    Iterable<Review> reviews = reviewRepo.findByRestaurant(restaurant);

    double totalRating = 0;
    int count = 0;

    for (Review review : reviews) {
      totalRating += review.getRating();
      count++;
    }

    if (count == 0) {
      return "No ratings yet";
    } else {
      double averageRating = totalRating / count;
      return String.format("%.2f", averageRating);
    }
  }
}
