package com.deliveryfoodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryfoodapp.DTO.OrderDTO;
import com.deliveryfoodapp.DTO.OrderItemDTO;
import com.deliveryfoodapp.exceptions.NotFoundException;
import com.deliveryfoodapp.exceptions.WithoutBalanceException;
import com.deliveryfoodapp.model.Customer;
import com.deliveryfoodapp.model.MenuItem;
import com.deliveryfoodapp.model.Order;
import com.deliveryfoodapp.model.OrderItem;
import com.deliveryfoodapp.model.Wallet;
import com.deliveryfoodapp.repository.CustomerRepository;
import com.deliveryfoodapp.repository.MenuItemRepository;
import com.deliveryfoodapp.repository.OrderItemRepository;
import com.deliveryfoodapp.repository.OrderRepository;
import com.deliveryfoodapp.service.OrderService;

@RestController
public class OrderController {

  @Autowired
  private CustomerRepository customerRepo;

  @Autowired
  private OrderRepository orderRepo;

  @Autowired
  private OrderItemRepository orderItemRepo;

  @Autowired
  private MenuItemRepository menuItemRepo;
  
  @Autowired
  private OrderService orderService;

  @PostMapping("/order")
  public Order createOrder(@RequestBody OrderDTO orderDTO) {
    Customer customer = customerRepo.findById(orderDTO.getCustomerId());

    if (customer == null) {
    	throw new NotFoundException("Customer", orderDTO.getCustomerId());
    }
    double totalAmount = orderService.getTotalAmount(orderDTO);
    Wallet wallet = customer.getWallet();
    
	if (wallet.getBalance() < totalAmount) {
    	throw new WithoutBalanceException(customer.getName());
    }

    Order order = new Order(customer);

    for (OrderItemDTO orderItemDTO : orderDTO.getItems()) {
      MenuItem menuItem = menuItemRepo.findById(orderItemDTO.getItemId());
      if (menuItem == null) {
        throw new NotFoundException("MenuItem", orderItemDTO.getItemId());
      }
      OrderItem orderItem = new OrderItem(menuItem, orderItemDTO.getQuantity());
      order.addItem(orderItem);
      orderItemRepo.save(orderItem);
    }
    
    wallet.withdraw(totalAmount);
    orderRepo.save(order);

    return order;
  }
}
