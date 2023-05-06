package com.deliveryfoodapp.DTO;

import com.deliveryfoodapp.model.Address;

public class CustomerDTO {

  private String name;
  private Address address;

  public CustomerDTO() {

  }

  public CustomerDTO(String name, Address address) {
    this.name = name;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
