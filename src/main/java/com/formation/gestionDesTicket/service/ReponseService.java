package com.formation.gestionDesTicket.service;

import com.formation.gestionDesTicket.model.Reponse;

import java.util.List;

public interface ReponseService {
    Reponse creerReponse(Reponse reponse);
    List<Reponse> lireReponse();
    Reponse moddifierReponse(Long id,Reponse reponse);
    String suppReponse(Long id);
}
