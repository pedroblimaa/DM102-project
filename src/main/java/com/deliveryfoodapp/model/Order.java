package com.deliveryfoodapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @ManyToOne
  private Customer customer;

  @OneToMany
  private List<OrderItem> orderItems = new ArrayList<>();

  @Column
  private Date orderDate;

  @OneToOne
  private Address deliveryAddress;
  
  @Column
  private String status;
  
  @OneToOne
  private Driver driver;

  public Order() {

  }

  public Order(Customer customer) {
    this.customer = customer;
    this.orderDate = new Date();
    this.deliveryAddress = customer.getAddress();
    this.status = "PREPARING ORDER";
    this.driver = null;
  }

  public Long getOrderId() {
    return id;
  }

  public void setOrderId(Long orderId) {
    this.id = orderId;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public Address getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(Address deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void addItem(OrderItem orderItem) {
    this.orderItems.add(orderItem);
  }
  
  public Driver getDriver() {
	return driver;
  }
  
  public void setDriver(Driver driver) {
	this.driver = driver;
  }
}