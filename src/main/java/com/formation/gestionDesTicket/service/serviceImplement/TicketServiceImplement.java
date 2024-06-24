package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.Mail.Messagerie;
import com.formation.gestionDesTicket.model.Apprenant;
import com.formation.gestionDesTicket.model.Ticket;
import com.formation.gestionDesTicket.model.Utilisateur;
import com.formation.gestionDesTicket.repository.TicketRepository;
import com.formation.gestionDesTicket.service.TicketService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
public class TicketServiceImplement implements TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    private Messagerie messagerie;

    @Override
    public Ticket creerTicket(Ticket ticket) {
        messagerie.envoiesMessage(ticket.getApprenant().getEmail(), "Votre ticket a été créer.");
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> lire() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket modifTicket(Long idTicket, Ticket ticket) {
        return null;
    }


    @Override
    public String supprimTicket(Long idTicket) {
        return null;
    }
}
