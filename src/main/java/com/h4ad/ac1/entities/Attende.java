package com.h4ad.ac1.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.h4ad.ac1.dto.AttendeInsertDTO;
import com.h4ad.ac1.entities.common.BaseUser;

@Entity
@DiscriminatorValue("attendees")
public class Attende extends BaseUser {

  private double balance;

  @OneToMany(
    mappedBy = "attende",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Ticket> tickets;

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

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }  
}
