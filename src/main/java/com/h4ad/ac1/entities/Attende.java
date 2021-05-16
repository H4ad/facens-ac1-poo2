package com.h4ad.ac1.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.h4ad.ac1.entities.common.BaseUser;

@Entity
@DiscriminatorValue("attende")
public class Attende extends BaseUser {

  private Double balance;

  public Attende() {

  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }
}
