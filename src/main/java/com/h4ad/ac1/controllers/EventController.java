package com.h4ad.ac1.controllers;

import java.util.List;

import com.h4ad.ac1.dto.EventDTO;
import com.h4ad.ac1.dto.EventInsertDTO;
import com.h4ad.ac1.dto.EventUpdateDTO;
import com.h4ad.ac1.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

  @Autowired
  private EventService service;

  @GetMapping
  public ResponseEntity<List<EventDTO>> getEvents() {
    return ResponseEntity.ok(service.getEvents());
  }

  @PostMapping
  public ResponseEntity<EventDTO> createEvent(@RequestBody EventInsertDTO dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createEvent(dto));
  }

  @PutMapping("{eventId}")
  public ResponseEntity<EventDTO> updateEvent(@PathVariable Long eventId, @RequestBody EventUpdateDTO dto) {
    return ResponseEntity.ok(service.updateEvent(eventId, dto));
  }
}
