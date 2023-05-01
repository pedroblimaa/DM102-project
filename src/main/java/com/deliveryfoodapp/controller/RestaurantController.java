package com.deliveryfoodapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryfoodapp.DTO.RestaurantDTO;
import com.deliveryfoodapp.exceptions.NotFoundException;
import com.deliveryfoodapp.model.Category;
import com.deliveryfoodapp.model.MenuItem;
import com.deliveryfoodapp.model.Restaurant;
import com.deliveryfoodapp.repository.CategoryRepository;
import com.deliveryfoodapp.repository.RestaurantRepository;

@RestController
public class RestaurantController {

  @Autowired
  private RestaurantRepository restaurantRepo;

  @Autowired
  private CategoryRepository categoryRepo;

  @GetMapping("/category")
  public List<Category> listCategories() {
    return categoryRepo.findAll();
  }

  @GetMapping("/restaurant")
  public List<RestaurantDTO> listRestaurants(@RequestParam(required = false) Long categoryId) {
    List<Restaurant> restaurants;

    if (categoryId != null) {
      Category category = categoryRepo.findById(categoryId);
      if (category == null) {
        throw new NotFoundException("Category", categoryId);
      }
      restaurants = restaurantRepo.findByCategory(category);
    } else {
      restaurants = restaurantRepo.findAll();
    }

    return restaurants.stream()
        .map(RestaurantDTO::new)
        .collect(Collectors.toList());
  }

  @GetMapping("/restaurant/{restaurantId}/menu")
  public List<MenuItem> getMenuItems(@PathVariable("restaurantId") Long restaurantId) {
    Restaurant restaurant = restaurantRepo.findById(restaurantId);

    if (restaurant == null) {
      throw new NotFoundException("Restaurant", restaurantId);
    }

    return restaurant.getMenuItems();
  }
}
