package com.h4ad.ac1.dto;

import com.h4ad.ac1.entities.Place;

public class PlaceDTO {

  private Long id;

  private String name;

  private String address;

  public PlaceDTO(Place entity) {
    setId(entity.getId());
    setName(entity.getName());
    setAddress(entity.getAddress());
  }

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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}