package com.h4ad.ac1.services;

import java.util.ArrayList;
import java.util.List;

import com.h4ad.ac1.dto.EventDTO;
import com.h4ad.ac1.entities.Event;
import com.h4ad.ac1.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired
  private EventRepository repository;

  public List<EventDTO> getEvents() {
    return toDTOList(repository.findAll());
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
