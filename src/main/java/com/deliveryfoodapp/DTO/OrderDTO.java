package com.deliveryfoodapp.DTO;

import java.util.List;

import com.deliveryfoodapp.model.Customer;
import com.deliveryfoodapp.model.Order;

public class OrderDTO {

  private Long restaurantId;
  private Long customerId;
  private List<OrderItemDTO> items;

  public OrderDTO() {

  }

  public OrderDTO(Long restaurantId, Long customerId, List<OrderItemDTO> items) {
    this.restaurantId = restaurantId;
    this.customerId = customerId;
    this.items = items;
  }

  public Long getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(Long restaurantId) {
    this.restaurantId = restaurantId;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public List<OrderItemDTO> getItems() {
    return items;
  }

  public void setItems(List<OrderItemDTO> items) {
    this.items = items;
  }

  public Object getTotalAmount() {
    return null;
  }
}
