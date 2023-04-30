package com.deliveryfoodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryfoodapp.DTO.OrderDTO;
import com.deliveryfoodapp.DTO.OrderItemDTO;
import com.deliveryfoodapp.exceptions.NotFoundException;
import com.deliveryfoodapp.model.Customer;
import com.deliveryfoodapp.model.MenuItem;
import com.deliveryfoodapp.model.Order;
import com.deliveryfoodapp.model.OrderItem;
import com.deliveryfoodapp.repository.CustomerRepository;
import com.deliveryfoodapp.repository.MenuItemRepository;
import com.deliveryfoodapp.repository.OrderRepository;

@RestController
public class OrderController {

  @Autowired
  private CustomerRepository customerRepo;

  @Autowired
  private OrderRepository orderRepo;

  @Autowired
  private MenuItemRepository menuItemRepo;

  @PostMapping("/order")
  public void createOrder(@RequestBody OrderDTO orderDTO) {
    Customer customer = customerRepo.findById(orderDTO.getCustomerId());

    if (customer == null) {
      throw new NotFoundException("Customer", orderDTO.getCustomerId());
    }

    Order order = new Order(customer);

    for (OrderItemDTO orderItemDTO : orderDTO.getItems()) {
      MenuItem menuItem = menuItemRepo.findById(orderItemDTO.getItemId());
      if (menuItem == null) {
        throw new NotFoundException("MenuItem", orderItemDTO.getItemId());
      }
      OrderItem orderItem = new OrderItem(menuItem.getId(), orderItemDTO.getQuantity());
      order.addItem(orderItem);
    }

    orderRepo.save(order);
  }
}
