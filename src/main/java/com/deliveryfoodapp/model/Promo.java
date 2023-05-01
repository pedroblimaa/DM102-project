package com.deliveryfoodapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "promo")
public class Promo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long promoId;

  @Column
  private String name;

  @Column
  private String description;

  @Column
  private double discount;

  public Promo() {

  }

  public Promo(String name, String description, double discount) {
    this.name = name;
    this.description = description;
    this.discount = discount;
  }

  public Long getPromoId() {
    return promoId;
  }

  public void setPromoId(Long promoId) {
    this.promoId = promoId;
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

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }
}