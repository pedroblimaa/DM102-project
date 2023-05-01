package com.deliveryfoodapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Customer customer;

  @ManyToOne
  private Restaurant restaurant;

  @Column
  private String reviewDescription;

  @Column
  private Long rating;

  public Review() {
  }

  public Review(Customer customer, Restaurant restaurant, String reviewDescription, Long rating) {
    this.customer = customer;
    this.restaurant = restaurant;
    this.reviewDescription = reviewDescription;
    this.rating = rating;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCustomerName() {
    return customer.getName();
  }

  public String getRestaurantName() {
    return restaurant.getName();
  }

  public String getReviewDescription() {
    return reviewDescription;
  }

  public void setReviewDescription(String reviewDescription) {
    this.reviewDescription = reviewDescription;
  }

  public Long getRating() {
    return rating;
  }

  public void setRating(Long rating) {
    this.rating = rating;
  }

  public String getSummary() {
    String customerName = getCustomerName();
    String restaurantName = getRestaurantName();
    String truncatedDescription = reviewDescription.substring(0, Math.min(reviewDescription.length(), 50)) + "...";

    return String.format("%s reviewed %s and gave it a rating of %d stars. Review: \"%s\"", customerName,
        restaurantName, rating, truncatedDescription);
  }
}