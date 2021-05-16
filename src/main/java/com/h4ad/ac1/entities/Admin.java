package com.h4ad.ac1.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.h4ad.ac1.dto.AdminInsertDTO;
import com.h4ad.ac1.entities.common.BaseUser;

@Entity
@DiscriminatorValue("admin")
public class Admin extends BaseUser {

  private String phoneNumber;

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
}
