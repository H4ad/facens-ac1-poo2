package com.h4ad.ac1.repositories;

import com.h4ad.ac1.entities.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>, JpaSpecificationExecutor<Ticket> {

  @Nullable
  Ticket findByAttendeIdAndEventId(Long attendeId, Long eventId);

}
