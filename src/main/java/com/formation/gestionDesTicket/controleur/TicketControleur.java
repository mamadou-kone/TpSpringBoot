package com.formation.gestionDesTicket.controleur;

import com.formation.gestionDesTicket.model.Ticket;
import com.formation.gestionDesTicket.service.TicketService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/ticket")
public class TicketControleur {
    private final TicketService ticketService;
    @PostMapping("/ajouterTicket")
    public Ticket creerTic(@RequestBody Ticket ticket){
        return ticketService.creerTicket(ticket);
    }
    @GetMapping("/listTicket")
    public List<Ticket>lire(){
        return ticketService.lire();
    }
    @PutMapping("/modiffierTicket/{id}")
    public Ticket modifTicket(@PathVariable Long id,@RequestBody Ticket ticket){
        return ticketService.modifTicket(id,ticket);
    }
    @DeleteMapping("supprimTicket")
    public String suppTicket(@PathVariable Long id){
        return ticketService.supprimTicket(id);
    }
}
