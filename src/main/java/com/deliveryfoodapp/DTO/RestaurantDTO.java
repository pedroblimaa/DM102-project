package com.deliveryfoodapp.DTO;

import com.deliveryfoodapp.model.Restaurant;

import lombok.Data;

@Data
public class RestaurantDTO {

  private Long id;
  private String name;
  private String address;
  private String phone;
  private String categoryName;

  public RestaurantDTO() {

  }

  public RestaurantDTO(Restaurant restaurant) {
    this.id = restaurant.getId();
    this.name = restaurant.getName();
    this.address = restaurant.getAddress();
    this.phone = restaurant.getPhone();
    this.categoryName = restaurant.getCategory().getName();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getCategoryName() {
    return categoryName;
  }
}
