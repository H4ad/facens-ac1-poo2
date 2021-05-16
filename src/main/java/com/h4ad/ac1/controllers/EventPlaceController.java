package com.h4ad.ac1.controllers;

import com.h4ad.ac1.services.EventPlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events/{eventId}/places/{placeId}")
public class EventPlaceController {

  @Autowired
  private EventPlaceService service;

  @PostMapping
  public ResponseEntity<Void> addPlaceToEvent(@PathVariable Long eventId, @PathVariable Long placeId) {
    service.addPlaceToEvent(eventId, placeId);

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping
  public ResponseEntity<Void> removePlaceToEvent(@PathVariable Long eventId, @PathVariable Long placeId) {
    service.removePlaceFromEvent(eventId, placeId);

    return ResponseEntity.noContent().build();
  }
}
