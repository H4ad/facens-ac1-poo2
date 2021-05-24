package com.h4ad.ac1.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.h4ad.ac1.dto.AttendeInsertDTO;
import com.h4ad.ac1.entities.common.BaseUser;

@Entity
@DiscriminatorValue("attendees")
public class Attende extends BaseUser {

  private double balance;

  public Attende() {

  }

  public Attende(AttendeInsertDTO attende) {
    setName(attende.getName());
    setEmail(attende.getEmail());
    setBalance(0);
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
