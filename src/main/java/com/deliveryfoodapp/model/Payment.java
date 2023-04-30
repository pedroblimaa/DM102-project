package com.deliveryfoodapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String cardholderName;

  @Column
  private String cardNumber;

  @Column
  private Long expirationMonth;

  @Column
  private Long expirationYear;

  @Column
  private Long cvv;

  public Payment() {
  }

  public Payment(String cardholderName, String cardNumber, Long expirationMonth, Long expirationYear, Long cvv) {
    this.cardholderName = cardholderName;
    this.cardNumber = cardNumber;
    this.expirationMonth = expirationMonth;
    this.expirationYear = expirationYear;
    this.cvv = cvv;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCardholderName() {
    return cardholderName;
  }

  public void setCardholderName(String cardholderName) {
    this.cardholderName = cardholderName;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public Long getExpirationMonth() {
    return expirationMonth;
  }

  public void setExpirationMonth(Long expirationMonth) {
    this.expirationMonth = expirationMonth;
  }

  public Long getExpirationYear() {
    return expirationYear;
  }

  public void setExpirationYear(Long expirationYear) {
    this.expirationYear = expirationYear;
  }

  public Long getCvv() {
    return cvv;
  }

  public void setCvv(Long cvv) {
    this.cvv = cvv;
  }

}
