package com.h4ad.ac1.services;

import com.h4ad.ac1.dto.EventDTO;
import com.h4ad.ac1.dto.TicketInsertDTO;
import com.h4ad.ac1.dto.TicketType;
import com.h4ad.ac1.entities.Attende;
import com.h4ad.ac1.entities.Event;
import com.h4ad.ac1.entities.Ticket;
import com.h4ad.ac1.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TicketService {

  @Autowired
  private AttendeService attendeService;

  @Autowired
  private EventService eventService;

  @Autowired
  private TicketRepository repository;

  public void sellTicket(Long eventId, TicketInsertDTO dto) {
    Ticket selledTicket = repository.findByAttendeIdAndEventId(dto.getAttendeId(), eventId);

    if (selledTicket != null)
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Você não pode vender mais de um ingresso para a mesma pessoa.");

    Event event = eventService.getEventEntity(eventId);
    Attende attende = attendeService.getAttendeeEntity(dto.getAttendeId());

    Ticket ticket = new Ticket(dto);

    if (dto.getType() == TicketType.FREE) {
      Long amountFreeTickets = event.getAmountFreeTickets();
      Long freeTicketsSelled = event.getFreeTicketsSelled();

      if (freeTicketsSelled >= amountFreeTickets)
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
            "Não há mais ingressos gratuítos disponíveis para esse evento para ser vendido.");

      ticket.setPrice(0);
      event.setFreeTicketsSelled(freeTicketsSelled + 1);
    } else if (dto.getType() == TicketType.PAID) {
      Long amountPaidTickets = event.getAmountPayedTickets();
      Long paidTicketsSelled = event.getPayedTicketsSelled();

      if (paidTicketsSelled >= amountPaidTickets)
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
            "Não há mais ingressos pagos disponíveis para esse evento para ser vendido.");

      ticket.setPrice(event.getPriceTicket());
      event.setPayedTicketsSelled(paidTicketsSelled + 1);
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não há como vender esse tipo de ingresso.");
    }

    ticket.setAttende(attende);
    ticket.setEvent(event);

    repository.save(ticket);

    eventService.getRepository().save(event);
    attendeService.getRepository().save(attende);
  }

  public void removeTicket(Long eventId, TicketInsertDTO dto) {
    Ticket ticket = repository.findByAttendeIdAndEventId(dto.getAttendeId(), eventId);

    if (ticket == null)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhum ingresso para esse usuário para esse evento.");

    Event event = ticket.getEvent();
    Attende attende = ticket.getAttende();

    if (ticket.getType() == TicketType.FREE) {
      Long freeTicketsSelled = event.getFreeTicketsSelled();

      event.setFreeTicketsSelled(freeTicketsSelled - 1);
    } else if (ticket.getType() == TicketType.PAID) {
      Long paidTicketsSelled = event.getPayedTicketsSelled();

      event.setPayedTicketsSelled(paidTicketsSelled - 1);

      attende.setBalance(attende.getBalance() + event.getPriceTicket());
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não há como remover esse tipo de ingresso.");
    }

    eventService.getRepository().save(event);
    attendeService.getRepository().save(attende);

    repository.delete(ticket);
  }

  public EventDTO getEventAndTickets(Long eventId) {
    Event event = eventService.getEventEntity(eventId);

    return new EventDTO(event, true, true);
  }
}
