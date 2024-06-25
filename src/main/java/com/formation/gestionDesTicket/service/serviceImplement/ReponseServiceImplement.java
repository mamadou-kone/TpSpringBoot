package com.formation.gestionDesTicket.service.serviceImplement;

import com.formation.gestionDesTicket.Mail.Messagerie;
import com.formation.gestionDesTicket.model.Reponse;
import com.formation.gestionDesTicket.model.Ticket;
import com.formation.gestionDesTicket.repository.AprenantRepository;
import com.formation.gestionDesTicket.repository.ReponseRepository;
import com.formation.gestionDesTicket.repository.TicketRepository;
import com.formation.gestionDesTicket.service.ReponseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class ReponseServiceImplement implements ReponseService {
    @Autowired
    ReponseRepository reponseRepository ;
    @Autowired
    private Messagerie messagerie;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    AprenantRepository aprenantRepository;
    @Override
    public Reponse creerReponse(Long id,Reponse reponse) {
        ticketRepository.findById(id)
                        .map(T-> {
                            aprenantRepository.findById(T.getApprenant().getId())
                                    .map(A->{
                                        T.setStatuts("Repondu");
                                        reponse.setTicket(T);
                                      return   ticketRepository.save(T);
                                    }).orElseThrow(()->new RuntimeException());
                              return reponseRepository.save(reponse);
                        }).orElseThrow(()->new RuntimeException());
        messagerie.envoiesMessage(reponse.getTicket().getApprenant().getEmail(),"Votre ticket a été répondu");
        return reponseRepository.save(reponse);
    }

    @Override
    public List<Reponse> lireReponse() {
        return reponseRepository.findAll();
    }

    @Override
    public Reponse moddifierReponse(Long id, Reponse reponse) {
        return reponseRepository.findById(id)
                .map((re)->{
                    re.setCorpReponse(re.getCorpReponse());
                    re.setFormateur(re.getFormateur());
                    re.setTicket(re.getTicket());
                    return reponseRepository.save(re);
                }).orElseThrow(()->new RuntimeException("Role introuvable"));
    }

    @Override
    public String suppReponse(Long id) {
        reponseRepository.deleteById(id);
        return "Reponse supprimer";
    }
}
