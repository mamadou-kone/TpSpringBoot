package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.Mail.Messagerie;
import com.formation.gestionDesTicket.model.Apprenant;
import com.formation.gestionDesTicket.model.Ticket;
import com.formation.gestionDesTicket.model.Utilisateur;
import com.formation.gestionDesTicket.repository.TicketRepository;
import com.formation.gestionDesTicket.repository.UserRepository;
import com.formation.gestionDesTicket.securiteConfig.SessionUser;
import com.formation.gestionDesTicket.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.formation.gestionDesTicket.securiteConfig.UserDetailService;

import javax.swing.*;
import java.util.List;
import java.util.Optional;



@Data
@Service
@AllArgsConstructor
//@AllArgsConstructor
public class TicketServiceImplement implements TicketService {
    private final TicketRepository ticketRepository;
    UserDetailService userdetail;
    @Autowired
    private SessionUser sessionUser;

    @Autowired
    private Messagerie messagerie;
    private UserRepository userRepository;

    @Override
    public Ticket creerTicket(Ticket ticket) {
        Optional<Utilisateur> utilisateur=sessionUser.getAuthenticatedUser();

        ticket.setApprenant((Apprenant) utilisateur.get());
        messagerie.envoiesMessage(utilisateur.get().getEmail(), "Votre ticket a été créer.");
        //messagerie.envoiesMessage(ticket.getApprenant().getFormateur().getEmail(),"un ticket a été soumis par "+ticket.getApprenant().getPrenom()+" "+ticket.getApprenant().getNom());
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> lire() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket modifTicket(Long idTicket, Ticket ticket) {
        return ticketRepository.findById(idTicket)
                .map((t)->{
                    t.setMotif(t.getMotif());
                    t.setDate(t.getDate());
                    t.setIdTicket(t.getIdTicket());
                  return   ticketRepository.save(t);
                }).orElseThrow(()->new RuntimeException());
    }

    @PatchMapping("/ouvirirTicket/{id}")
    @Override
    public Ticket ouvrir(@PathVariable Long id, Ticket ticket) {
        return ticketRepository.findById(id)
                .map((o)->{
                    messagerie.envoiesMessage(o.getApprenant().getEmail(),"Votre ticket a été ouvert");
                    o.setStatuts("Ouvert");
                    o.setApprenant(o.getApprenant());
                   return ticketRepository.save(o);
                }).orElseThrow(()->new RuntimeException());
    }


    @Override
    public String supprimTicket(Long idTicket) {
        ticketRepository.deleteById(idTicket);
        return "ticket supprimer";
    }


}
