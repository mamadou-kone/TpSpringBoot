package com.formation.gestionDesTicket.service;

import com.formation.gestionDesTicket.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket creerTicket(Ticket ticket);
    List<Ticket>lire();
    Ticket modifTicket(Long idTicket,Ticket ticket);
    Ticket ouvrir(Long id,Ticket ticket);
    String supprimTicket(Long idTicket);
}
