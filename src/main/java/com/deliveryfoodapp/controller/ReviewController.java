package com.deliveryfoodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryfoodapp.DTO.ReviewDTO;
import com.deliveryfoodapp.model.Customer;
import com.deliveryfoodapp.model.Restaurant;
import com.deliveryfoodapp.model.Review;
import com.deliveryfoodapp.repository.ReviewRepository;
import com.deliveryfoodapp.service.CustomerService;
import com.deliveryfoodapp.service.RestaurantService;
import com.deliveryfoodapp.service.ReviewService;

@RestController
public class ReviewController {

  @Autowired
  private ReviewRepository reviewRepo;

  @Autowired
  private CustomerService customerService;

  @Autowired
  private RestaurantService restaurantService;

  @Autowired
  private ReviewService reviewService;

  @PostMapping("/review")
  public Review registerReview(@RequestBody ReviewDTO reviewDTO) {
    if (reviewDTO.getRating() < 1 || reviewDTO.getRating() > 5) {
      throw new IllegalArgumentException("Rating must be between 1 and 5.");
    }

    Customer customer = customerService.getCustomerById(reviewDTO.getCustomerId());
    Restaurant restaurant = restaurantService.getRestaurantById(reviewDTO.getRestaurantId());

    if (reviewRepo.findByCustomerAndRestaurant(customer, restaurant) != null) {
      throw new IllegalArgumentException("Review already exists.");
    }

    Review review = new Review(customer, restaurant, reviewDTO.getDescription(),
        reviewDTO.getRating());

    reviewRepo.save(review);

    return review;
  }

  @GetMapping("/review/restaurant/{id}")
  public Iterable<Review> getReviewsByRestaurantId(@PathVariable Long id) {
    Restaurant restaurant = restaurantService.getRestaurantById(id);

    return reviewRepo.findByRestaurant(restaurant);
  }

  @GetMapping("/review/average/restaurant/{id}")
  public Object getAverageRatingByRestaurantId(@PathVariable Long id) {
    Restaurant restaurant = restaurantService.getRestaurantById(id);

    String averageRating = reviewService.getAverageRatingByRestaurant(restaurant);
   
    return new Object() {
      public final Long restaurantId = id;
      public final String rating = averageRating;
    };
  }
}
