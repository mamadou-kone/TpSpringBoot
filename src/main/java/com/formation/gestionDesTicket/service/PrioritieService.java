package com.formation.gestionDesTicket.service;

import com.formation.gestionDesTicket.model.Priorite;

import java.util.List;

public interface PrioritieService {
    Priorite creerPriorite(Priorite priorite);

    List<Priorite>lire();
    Priorite modifPriorite(Long idPriorite,Priorite priorite);
    String supprimPriorite (Long idPriorite);

}
