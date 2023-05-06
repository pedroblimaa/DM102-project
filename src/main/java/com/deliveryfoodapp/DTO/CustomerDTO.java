package com.deliveryfoodapp.DTO;

import com.deliveryfoodapp.model.Address;
import com.deliveryfoodapp.model.Wallet;

public class CustomerDTO {

  private String name;
  private Address address;
  private Wallet wallet;

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
  
  public Wallet getWallet() {
	return wallet;
  }

  public void setWallet(Wallet wallet) {
	this.wallet = wallet;
  }
}
