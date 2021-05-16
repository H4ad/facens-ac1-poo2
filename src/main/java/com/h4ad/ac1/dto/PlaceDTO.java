package com.h4ad.ac1.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.h4ad.ac1.entities.Place;

public class PlaceDTO {

  private Long id;

  private String name;

  private String address;

  private List<EventDTO> events;

  public PlaceDTO(Place entity) {
    setId(entity.getId());
    setName(entity.getName());
    setAddress(entity.getAddress());
  }

  public PlaceDTO(Place entity, boolean shouldIncludeJoins) {
    this(entity);

    if (shouldIncludeJoins)
      setEvents(entity.getEvents().stream().map(event -> new EventDTO(event, false)).collect(Collectors.toList()));
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

  public List<EventDTO> getEvents() {
    return events;
  }

  public void setEvents(List<EventDTO> events) {
    this.events = events;
  }
}