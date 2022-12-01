package com.bosonit.BackendFrontend.ticket.infrastructure.repository;

import com.bosonit.BackendFrontend.ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket,Long> {
}
