package com.h4ad.ac1.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.h4ad.ac1.dto.EventDTO;
import com.h4ad.ac1.dto.EventInsertDTO;
import com.h4ad.ac1.dto.EventUpdateDTO;
import com.h4ad.ac1.entities.Event;
import com.h4ad.ac1.repositories.EventRepository;
import com.h4ad.ac1.specifications.EventSearchCriteria;
import com.h4ad.ac1.specifications.EventSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventService {

  @Autowired
  private EventRepository repository;

  public Page<Event> getEvents(
    Optional<String> pageString, 
    Optional<String> limitString,
    Optional<String> name,
    Optional<String> place,
    Optional<String> description,
    Optional<String> emailContact,
    Optional<LocalDate> startDate
  ) {
    int page = Math.max(Integer.parseInt(pageString.orElse("0")), 0);
    int limit = Math.min(Math.max(Integer.parseInt(limitString.orElse("5")), 5), 2000);

    Specification<Event> spec = null;

    if (!name.isEmpty()) {
      spec = EventSpecification.add(spec, new EventSearchCriteria("name", ":", name.get()));
    }

    if (!place.isEmpty()) {
      spec = EventSpecification.add(spec, new EventSearchCriteria("place", ":", place.get()));
    }

    if (!description.isEmpty()) {
      spec = EventSpecification.add(spec, new EventSearchCriteria("description", ":", description.get()));
    }

    if (!emailContact.isEmpty()) {
      spec = EventSpecification.add(spec, new EventSearchCriteria("emailContact", ":", emailContact.get()));
    }

    if (!startDate.isEmpty()) {
      spec = EventSpecification.add(spec, new EventSearchCriteria("startDate", ":", startDate.get()));
    }

    return repository.findAll(spec, PageRequest.of(page, limit));
  }

  public EventDTO getEvent(Long eventId) {
    Event entity = repository.findById(eventId).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O evento com essa identificação não foi encontrado."));

    return new EventDTO(entity);
  }

  public EventDTO createEvent(EventInsertDTO dto) {
    Event entity = new Event(dto);

    entity = repository.save(entity);

    return new EventDTO(entity);
  }

  public EventDTO updateEvent(Long eventId, EventUpdateDTO dto) {
    Event entity = repository.findById(eventId).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O evento com essa identificação não foi encontrado."));

    entity.setName(dto.getName());
    entity.setDescription(dto.getDescription());
    entity.setPlace(dto.getPlace());
    entity.setEmailContact(dto.getEmailContact());
    entity.setStartDate(dto.getStartDate());
    entity.setEndDate(dto.getEndDate());
    entity.setStartTime(dto.getStartTime());
    entity.setEndTime(dto.getEndTime());

    entity = repository.save(entity);

    return new EventDTO(entity);
  }

  public void deleteEvent(Long eventId) {
    try {
      repository.deleteById(eventId);
    } catch (EmptyResultDataAccessException ex) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O evento com essa identificação não foi encontrado.");
    }
  }

  public List<EventDTO> toDTOList(List<Event> list) {
    List<EventDTO> listDTO = new ArrayList<>();

    for (Event event : list) {
      EventDTO dto = new EventDTO(event);

      listDTO.add(dto);
    }

    return listDTO;
  }
}
