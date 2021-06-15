package com.h4ad.ac1.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.h4ad.ac1.entities.Event;
import com.h4ad.ac1.entities.Place;
import com.h4ad.ac1.repositories.EventRepository;
import com.h4ad.ac1.repositories.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventPlaceService {

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private PlaceRepository placeRepository;

  public void addPlaceToEvent(Long eventId, Long placeId) {
    Event event = eventRepository.findById(eventId).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O Evento com essa identificação não foi encontrado."));

    List<Place> places = event.getPlaces();

    for (Place eventPlace : places) {
      if (eventPlace.getId() != placeId)
        continue;

      throw new ResponseStatusException(HttpStatus.CONFLICT, "Esse lugar já está associado a esse evento.");
    }

    Place place = placeRepository.findById(placeId).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O Lugar com essa identificação não foi encontrado."));

    List<Event> placeEvents = place.getEvents();

    for(Event placeEvent : placeEvents) {
      if (!placeEvent.intersectsDateWith(event))
        continue;

      throw new ResponseStatusException(HttpStatus.CONFLICT, "Você não pode associar esse lugar com o evento porque já existe um evento no mesmo horário.");
    }

    places.add(place);

    eventRepository.save(event);
  }

  public void removePlaceFromEvent(Long eventId, Long placeId) {
    Event event = eventRepository.findById(eventId).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O Evento com essa identificação não foi encontrado."));

    if (LocalDate.now().isAfter(event.getStartDate()) || (LocalDate.now().equals(event.getStartDate()) && LocalTime.now().isAfter(event.getStartTime())))
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Você não pode remover esse lugar desse evento porque ele já ocorreu.");
  
    List<Place> places = event.getPlaces();

    boolean placeWasRemoved = places.removeIf(place -> place.getId() == placeId);

    eventRepository.save(event);

    if (placeWasRemoved)
      return;

    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Esse lugar não está associado a esse evento.");
  }
}
