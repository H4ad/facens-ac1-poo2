package com.h4ad.ac1.controllers;

import com.h4ad.ac1.dto.EventDTO;
import com.h4ad.ac1.dto.TicketInsertDTO;
import com.h4ad.ac1.services.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events/{eventId}/tickets")
public class TicketController {

  @Autowired
  private TicketService service;

  @PostMapping
  public ResponseEntity<Void> sellTicket(@PathVariable Long eventId, @RequestBody TicketInsertDTO dto) {
    service.sellTicket(eventId, dto);

    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<EventDTO> getPlace(@PathVariable Long eventId) {
    return ResponseEntity.ok(service.getEventAndTickets(eventId));
  }

  @DeleteMapping
  public ResponseEntity<Void> deletePlace(@PathVariable Long eventId, @RequestBody TicketInsertDTO dto) {
    service.removeTicket(eventId, dto);

    return ResponseEntity.noContent().build();
  }
}
