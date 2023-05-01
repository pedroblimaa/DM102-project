package com.deliveryfoodapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurants")
public class Restaurant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column
  private String name;

  @Column
  private String address;

  @Column
  private String phone;

  @Column
  @OneToMany
  private List<MenuItem> menuItems;

  @OneToOne
  private Category category;

  public Restaurant() {

  }

  public Restaurant(String name, String address, String phone, List<MenuItem> menuItems) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.menuItems = menuItems;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public List<MenuItem> getMenuItems() {
    return menuItems;
  }

  public void addItemToMenu(MenuItem menuItem) {
    menuItems.add(menuItem);
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}