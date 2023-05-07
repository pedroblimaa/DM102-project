package com.deliveryfoodapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu_items")
public class MenuItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column
  private String name;

  @Column
  private String description;

  @Column
  private double price;

  public MenuItem() {

  }

  public MenuItem(String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long menuItemId) {
    this.id = menuItemId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void updatePrice(int priceIncreasePercentage) {
    this.price = this.price + (this.price * priceIncreasePercentage / 100);
  }
}