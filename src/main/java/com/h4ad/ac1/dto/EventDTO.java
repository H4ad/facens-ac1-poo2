package com.h4ad.ac1.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.h4ad.ac1.entities.Event;

public class EventDTO {
  
  public EventDTO() {

  }

  public EventDTO(Event event) {
    setId(event.getId());
    setName(event.getName());
    setDescription(event.getDescription());
    setPlace(event.getPlace());
    setEmailContact(event.getEmailContact());
    setStartDate(event.getStartDate());
    setEndDate(event.getEndDate());
    setStartTime(event.getStartTime());
    setEndTime(event.getEndTime());
    setAmountFreeTickets(event.getAmountFreeTickets());
    setAmountPayedTickets(event.getAmountPayedTickets());
    setPriceTicket(event.getPriceTicket());
    setFreeTicketsSelled(event.getFreeTicketsSelled());
    setPayedTicketsSelled(event.getPayedTicketsSelled());
  }

  private Long id;

  private String name;

  private String description;

  private String place;

  private String emailContact;

  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate startDate;

  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate endDate;

  private LocalTime startTime;

  private LocalTime endTime;

  private Long amountFreeTickets;

  private Long amountPayedTickets;

  private Double priceTicket;

  private Long freeTicketsSelled;
  
  private Long payedTicketsSelled;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public String getEmailContact() {
    return emailContact;
  }

  public void setEmailContact(String emailContact) {
    this.emailContact = emailContact;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalTime endTime) {
    this.endTime = endTime;
  }

  public Long getAmountFreeTickets() {
    return amountFreeTickets;
  }

  public void setAmountFreeTickets(Long amountFreeTickets) {
    this.amountFreeTickets = amountFreeTickets;
  }

  public Long getAmountPayedTickets() {
    return amountPayedTickets;
  }

  public void setAmountPayedTickets(Long amountPayedTickets) {
    this.amountPayedTickets = amountPayedTickets;
  }

  public Double getPriceTicket() {
    return priceTicket;
  }

  public void setPriceTicket(Double priceTicket) {
    this.priceTicket = priceTicket;
  }

  public Long getFreeTicketsSelled() {
    return freeTicketsSelled;
  }

  public void setFreeTicketsSelled(Long freeTicketsSelled) {
    this.freeTicketsSelled = freeTicketsSelled;
  }

  public Long getPayedTicketsSelled() {
    return payedTicketsSelled;
  }

  public void setPayedTicketsSelled(Long payedTicketsSelled) {
    this.payedTicketsSelled = payedTicketsSelled;
  }
}
