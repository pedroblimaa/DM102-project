package com.deliveryfoodapp.DTO;

public class ReviewDTO {

  private Long customerId;
  private Long restaurantId;
  private String description;
  private int rating;

  public ReviewDTO() {

  }

  public ReviewDTO(Long customerId, Long restaurantId, String description, int rating) {
    this.customerId = customerId;
    this.restaurantId = restaurantId;
    this.description = description;
    this.rating = rating;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public Long getRestaurantId() {
    return restaurantId;
  }

  public String getDescription() {
    return description;
  }

  public int getRating() {
    return rating;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public void setRestaurantId(Long restaurantId) {
    this.restaurantId = restaurantId;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

}
