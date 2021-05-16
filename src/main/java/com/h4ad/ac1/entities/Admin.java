package com.h4ad.ac1.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.h4ad.ac1.dto.AdminInsertDTO;
import com.h4ad.ac1.entities.common.BaseUser;

@Entity
@DiscriminatorValue("admin")
public class Admin extends BaseUser {

  private String phoneNumber;

  @OneToMany(
    mappedBy = "admin",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Event> events;

  public Admin() {

  }

  public Admin(AdminInsertDTO admin) {
    setName(admin.getName());
    setEmail(admin.getEmail());
    setPhoneNumber(admin.getPhoneNumber());
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
