package com.deliveryfoodapp.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryfoodapp.DTO.CustomerDTO;
import com.deliveryfoodapp.exceptions.CustomerAlreadyExistsException;
import com.deliveryfoodapp.model.Customer;
import com.deliveryfoodapp.repository.CustomerRepository;
import com.deliveryfoodapp.service.CustomerService;

@RestController
public class CustomerController {
  private Logger logger;

  @Autowired
  private CustomerRepository customerRepo;

  @Autowired
  private CustomerService customerService;

  public CustomerController() {
    logger = Logger.getLogger(CustomerController.class.getName());
  }

  @PostMapping("/customer")
  public Customer register(@RequestBody CustomerDTO customerDTO) {
    Customer customer = new Customer(customerDTO.getName(), customerDTO.getAddress());

    if (!customerService.customerExists(customer)) {
      customerRepo.save(customer);
    } else {
      throw new CustomerAlreadyExistsException("Customer already exists.");
    }

    logger.log(Level.FINE, String.format("Customer %s registered successfully.", customer.getId()));

    return customer;
  }

  @GetMapping("/customer")
  public List<Customer> listCustomers() {
    return customerRepo.findAll();
  }
}