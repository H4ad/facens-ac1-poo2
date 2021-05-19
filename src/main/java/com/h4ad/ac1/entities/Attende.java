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

  private String phoneNumber;

  @OneToMany(
    // mappedBy = "attendees",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Event> events;

  public Attende() {

  }

  public Attende(AttendeInsertDTO attende) {
    setName(attende.getName());
    setEmail(attende.getEmail());
    setPhoneNumber(attende.getPhoneNumber());
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public List<Event> getEvents() {
    return events;
  }

  public void setEvents(List<Event> events) {
    this.events = events;
  }
}
