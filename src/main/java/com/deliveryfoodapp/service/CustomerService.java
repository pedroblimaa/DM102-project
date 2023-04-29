package com.deliveryfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliveryfoodapp.model.Customer;
import com.deliveryfoodapp.repository.CustomerRepository;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository customerRepo;

  public boolean customerExists(Customer customer) {
    List<Customer> customerList = customerRepo.findAll();

    for (Customer custmr : customerList) {
      if (custmr.getName().equals(customer.getName()) && custmr.getAddress().equals(customer.getAddress())) {
        return true;
      }
    }

    return false;
  }
}
