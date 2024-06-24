package com.formation.gestionDesTicket.repository;

import com.formation.gestionDesTicket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
