package com.deliveryfoodapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "drivers")
public class Driver {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long deliveryPersonId;

  @Column
  private String name;

  @Column
  private String phone;

  @Column
  private String licensePlate;

  public Driver() {

  }

  public Driver(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  public Long getDeliveryPersonId() {
    return deliveryPersonId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void getLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public String setLicensePlate() {
    return licensePlate;
  }
}