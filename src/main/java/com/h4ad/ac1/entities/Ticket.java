package com.h4ad.ac1.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.h4ad.ac1.dto.TicketInsertDTO;
import com.h4ad.ac1.dto.TicketType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "TB_TICKET")
public class Ticket implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.ORDINAL)
  private TicketType type;

  private Instant date;

  private double price;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Attende attende;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Event event;

  public Ticket() {

  }

  public Ticket(TicketInsertDTO dto) {
    setType(dto.getType());
    setDate(Instant.now());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TicketType getType() {
    return type;
  }

  public void setType(TicketType type) {
    this.type = type;
  }

  public Instant getDate() {
    return date;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Attende getAttende() {
    return attende;
  }

  public void setAttende(Attende attende) {
    this.attende = attende;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }
}
